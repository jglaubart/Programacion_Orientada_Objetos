package Guias.guia4.ej11_Polynomial;

public class InvalidGradeException extends Exception {

    private static final String MESSAGE = "Invalid Grade";

    public InvalidGradeException() {
        super(MESSAGE);
    }
}
