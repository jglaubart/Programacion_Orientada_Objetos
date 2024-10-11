package Guias.guia4.ej6_Expressions;

public class NotExp extends Expression {
    private Expression exp;

    public NotExp(Expression exp) {
        this.exp = exp;
    }

    @Override
    public boolean evaluate(){
        return !exp.evaluate();
    }
}
