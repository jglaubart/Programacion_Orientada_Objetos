package Guias.guia4.ej10_CellPhone;

public class FriendNotFoundException extends Exception{

    private static final String MESSAGE = "Error while looking for number %s: Friend not found.";

    public FriendNotFoundException(String number) {
        super(String.format(MESSAGE, number));
    }
}
