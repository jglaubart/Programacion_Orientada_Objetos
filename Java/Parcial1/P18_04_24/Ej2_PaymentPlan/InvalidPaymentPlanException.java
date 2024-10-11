package Parcial1.P18_04_24.Ej2_PaymentPlan;

public class InvalidPaymentPlanException extends RuntimeException {
  private static final String MESSAGE = "Invalid Payment Plan.";

  public InvalidPaymentPlanException() {
        super(MESSAGE);
  }
}
