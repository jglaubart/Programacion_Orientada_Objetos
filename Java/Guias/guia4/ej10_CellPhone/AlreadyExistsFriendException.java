package Guias.guia4.ej10_CellPhone;

public class AlreadyExistsFriendException extends Exception{
    private static final String MESSAGE = "Error while trying to add number %s: Friend already exists.";

    public AlreadyExistsFriendException(String friend){
        super(MESSAGE.formatted(friend));
    }
}
