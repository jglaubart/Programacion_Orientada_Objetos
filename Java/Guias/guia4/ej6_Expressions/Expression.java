package Guias.guia4.ej6_Expressions;

public abstract class Expression {

    public abstract boolean evaluate();

    public Expression not(){
        return new NotExp(this);
    }

    public Expression and(Expression e){
        return new AndExp(this, e);
    }

    public Expression or(Expression e){
        return new OrExp(this, e);
    }


}
