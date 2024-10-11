package talleres.taller3.ej2;

public class CannotRideException extends Exception {
    private static final String message = "Error, saldo insuficiente";

    public CannotRideException() {
        super(message);
    }
}
