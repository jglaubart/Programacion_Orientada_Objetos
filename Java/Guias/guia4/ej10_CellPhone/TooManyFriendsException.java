package Guias.guia4.ej10_CellPhone;

public class TooManyFriendsException extends RuntimeException {

  private static final String MESSAGE = "Error while trying to add number %s: Too many friends already added";

    public TooManyFriendsException(String friend) {
      super(MESSAGE.formatted(friend));
    }
}
