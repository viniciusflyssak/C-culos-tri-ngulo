package exercicio_2;

public class Triangulo {
    double base;
    double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double calculaArea(){
        return ((this.base * this.altura) / 2);
    }
    
    public double calculaHipotenusa(){
        return Math.sqrt((this.base * this.base) + (this.altura * this.altura));
    }
    
    public double calculaPerimetro(){
        return (this.base + this.altura + calculaHipotenusa());
    }
}
