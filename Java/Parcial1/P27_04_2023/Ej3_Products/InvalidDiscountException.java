package Parcial1.P27_04_2023.Ej3_Products;

public class InvalidDiscountException extends RuntimeException {
  private static final String MESSAGE = "Invalid Discount for Brand %s";

  public InvalidDiscountException(String name) {
    super(MESSAGE.formatted(name));
  }
}
