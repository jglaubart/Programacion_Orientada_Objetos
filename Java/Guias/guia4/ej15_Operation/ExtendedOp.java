package Guias.guia4.ej15_Operation;

public enum ExtendedOp implements Operation {
    EXP("^"){
        @Override
        public double applyOp(double x,double y){
            return Math.pow(x,y);
        }
    },

    REMAINDER("%"){
        @Override
        public double applyOp(double x,double y){
            return x%y;
        }
    };

    private final String symbol;

    ExtendedOp(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
