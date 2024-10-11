package Guias.guia4.ej6_Expressions;

public class AndExp extends BinaryExpression{
    public AndExp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() && right.evaluate();
    }
}
