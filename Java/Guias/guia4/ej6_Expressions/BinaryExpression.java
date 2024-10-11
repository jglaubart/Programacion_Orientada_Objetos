package Guias.guia4.ej6_Expressions;

public abstract class BinaryExpression extends Expression {
    protected Expression right, left;

    public abstract boolean evaluate();

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
