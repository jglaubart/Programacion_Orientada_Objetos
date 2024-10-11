package Guias.guia4.ej15_Operation;

public class OperationTester {
    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        for(BasicOp operation : BasicOp.values()) {
            System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, operation.applyOp(x,y));
        }
        for(ExtendedOp operation : ExtendedOp.values()) {
            System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, operation.applyOp(x,y));
        }
    }

}
