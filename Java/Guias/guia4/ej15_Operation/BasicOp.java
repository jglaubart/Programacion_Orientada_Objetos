package Guias.guia4.ej15_Operation;

public enum BasicOp implements Operation {

    PLUS("+", (x,y) -> x + y),
    MINUS("-", (x,y) -> x - y),
    DIVIDE("", (x,y) -> x/y),
    MULTIPLY("*", (x,y) -> x*y);


    private final String symbol;
    private final Operation op;

    BasicOp(String symbol, Operation op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public double applyOp(double x, double y){
        return op.applyOp(x,y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
