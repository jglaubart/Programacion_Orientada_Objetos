package Guias.guia1.ej2_ComplexNumber;

public class ComplexNumber {
    private int real;
    private int imag;

    public ComplexNumber(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber(int real) {
        this.real = real;
        this.imag = 0;
    }

    public int getReal() {
        return this.real;
    }

    public int getImag() {
        return this.imag;
    }

    public ComplexNumber addNumber(ComplexNumber num){
        return new ComplexNumber(this.real + num.real /*puedo usar num.real solo pq estoy dentro de la clase*/, this.imag + num.getImag());
    }
}
