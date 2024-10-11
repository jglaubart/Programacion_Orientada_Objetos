package Guias.guia4.ej11_Polynomial;

public class InvalidIndexException extends Exception {

  private static final String MESSAGE = "Invalid Index";

    public InvalidIndexException() {
        super(MESSAGE);
    }
}
