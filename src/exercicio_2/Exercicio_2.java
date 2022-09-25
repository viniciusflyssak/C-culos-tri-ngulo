package exercicio_2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Exercicio_2 extends JFrame{
    private JTextField tfBase;
    private JTextField tfAltura;
    private JLabel lbBase;
    private JLabel lbAltura;
    private JTextArea taResultados;
    private JScrollPane spResultados;
    private JPanel pnBotoes;
    private JPanel pnDados;
    private JButton btFechar;
    private JButton btLimpar;
    private JButton btHipotenusa;
    private JButton btArea;
    private JButton btPerimetro;
    private Triangulo triangulo;    
    public Exercicio_2() {    
        taResultados = new JTextArea();
        tfBase = new JTextField();        
        tfAltura = new JTextField();
        lbBase = new JLabel("Base");
        lbAltura = new JLabel("Altura"); 
        spResultados = new JScrollPane(taResultados);
        btFechar = new JButton("Fechar");
        btLimpar = new JButton("Limpar");
        btHipotenusa = new JButton("Calcular Hipotenusa");
        btArea = new JButton("Calcular Área");
        btPerimetro = new JButton("Calcular Perímetro");
        pnBotoes = new JPanel();
        pnDados = new JPanel();     
        DecimalFormat df = new DecimalFormat("#,###.00");       
        
        btFechar.addActionListener((e) -> {
            System.exit(0);
        });
        
        btLimpar.addActionListener((e) -> {
            taResultados.setText("");
            tfAltura.setText("");
            tfBase.setText("");
        });
        
        btHipotenusa.addActionListener((e) -> {
            if (validar() == true){
                triangulo = new Triangulo(Double.parseDouble(tfBase.getText()), Double.parseDouble(tfAltura.getText()));
                taResultados.setText(taResultados.getText() + "Hipotenusa: " + df.format(triangulo.calculaHipotenusa()) + "\n");
                taResultados.setText(taResultados.getText() + "========================================" + "\n");
                triangulo = null;  
            }           
        });
        
        btPerimetro.addActionListener((e) -> {
            if (validar() == true){
                triangulo = new Triangulo(Double.parseDouble(tfBase.getText()), Double.parseDouble(tfAltura.getText()));
                taResultados.setText(taResultados.getText() + "Perímetro: " + df.format(triangulo.calculaPerimetro()) + "\n");
                taResultados.setText(taResultados.getText() + "========================================" + "\n");
                triangulo = null; 
            }
        });

        btArea.addActionListener((e) -> {
            if (validar() == true){
                triangulo = new Triangulo(Double.parseDouble(tfBase.getText()), Double.parseDouble(tfAltura.getText()));
                taResultados.setText(taResultados.getText() + "Área: " + df.format(triangulo.calculaArea()) + "\n");
                taResultados.setText(taResultados.getText() + "========================================" + "\n");
                triangulo = null;  
            }
        });        
        
        pnBotoes.add(btPerimetro);
        pnBotoes.add(btArea);
        pnBotoes.add(btHipotenusa);
        pnBotoes.add(btLimpar);
        pnBotoes.add(btFechar);
        pnDados.add(lbBase);
        pnDados.add(tfBase);
        pnDados.add(lbAltura);
        pnDados.add(tfAltura);
        tfBase.setColumns(10);                
        tfAltura.setColumns(10); 
        
        super.setTitle("Triângulo");
        super.setLayout(new BorderLayout(5,5));        
        super.add(pnDados, BorderLayout.NORTH);
        super.add(spResultados, BorderLayout.CENTER);
        super.add(pnBotoes, BorderLayout.SOUTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(800,600);
        super.setLocationRelativeTo(null);
        super.setVisible(true);                   
    }    
    
    public boolean validaApenasNumeros(JTextField Campo) { 
	long validacao; 
	if (Campo.getText().length() != 0){ 
		try { 
			validacao = Long.parseLong(Campo.getText()); 
		}catch(NumberFormatException ex){ 
			JOptionPane.showMessageDialog(null, "O  campo só aceita números! Verifique o campo em foco!" ,"Informação",JOptionPane.INFORMATION_MESSAGE); 
			Campo.grabFocus(); 
                        return false;
		} 
	}else{
            JOptionPane.showMessageDialog(null, "O  campo não pode estar vazio! Verifique o campo em foco!" ,"Informação",JOptionPane.INFORMATION_MESSAGE); 
            Campo.grabFocus();     
            return false;
        }
        return true;
    } 
    
    public boolean validar(){
        if ((validaApenasNumeros(tfBase) == false)) {
            return false;
        }else{ 
            if (validaApenasNumeros(tfAltura) == false){
                return false;
            }else{
                return true;
            }
        }    
    }
    
    public static void main(String[] args) {
        new Exercicio_2();
    }
}
