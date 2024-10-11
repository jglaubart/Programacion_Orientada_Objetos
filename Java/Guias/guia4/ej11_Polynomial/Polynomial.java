package Guias.guia4.ej11_Polynomial;

public class Polynomial {
    private int grade;
    private double[] coefficients;

    public Polynomial(int grade) throws InvalidGradeException {
        if (grade < 0) {
            throw new InvalidGradeException();
        }
        this.grade = grade;
        this.coefficients = new double[grade+1];
        for (int i = 0; i < grade; i++) {
            coefficients[i] = 0.0;
        }
    }

    public String set(int gr, double coeff) throws InvalidIndexException {
        if(gr < 0 || gr > coefficients.length) {
            throw new InvalidIndexException();
        }
        coefficients[gr] = coeff;
        return toString();
    }

    public double eval(double num){
        double ans = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            ans += coefficients[i] * Math.pow(num, i)   ;
        }
        return ans;
    }

    public String toString(){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < grade; i++) {
            if(coefficients[i] > 0.0) {
                ans.append(coefficients[i]).append("x^%d".formatted(i));
            }
        }
        return ans.toString();
    }
}



