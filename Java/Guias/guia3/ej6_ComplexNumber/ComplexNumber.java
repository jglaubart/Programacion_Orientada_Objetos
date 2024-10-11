package Guias.guia3.ej6_ComplexNumber;

import java.util.Objects;

public class ComplexNumber {
    private final double real, imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber(Number real) {
        this(real.doubleValue(), 0);
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public ComplexNumber plus(ComplexNumber num){
        return new ComplexNumber(this.real + num.real /*puedo usar num.real solo pq estoy dentro de la clase*/, this.imag + num.getImag());
    }

    public ComplexNumber plus(Number num){
        return plus(new ComplexNumber(num));
    }

    @Override
    public String toString() {
        return "%.2f %c %.2f".formatted(real, imag > 0 ? '+' : '-', Math.abs(imag));
    }


    @Override
    public boolean equals(Object num){
        return num instanceof ComplexNumber &&
                Double.compare(((ComplexNumber)num).real, this.real) == 0 &&
                Double.compare(((ComplexNumber)num).imag, this.imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }
}
