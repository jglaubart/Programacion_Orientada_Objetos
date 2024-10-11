package Parcial1.P23_09_21.Ej2_Directory;

public class ReachedLimitException extends RuntimeException {
  public ReachedLimitException(int max) {
    super("Reached limit of %d people".formatted(max));
  }
}
