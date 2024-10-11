package Parcial1.P22_09_2022.Ej3_Loan;

public enum Destinatary {
    PERSONAL(50000 ,12),
    VEHICLE(300000, 24),
    HOME(1000000, 360);

    private final long maxAmount;
    private final int maxFees;

    Destinatary(long maxAmount, int maxFees) {
        this.maxAmount = maxAmount;
        this.maxFees = maxFees;
    }

    public boolean canLoan(long amount, int fees) {
        return amount <= maxAmount && fees <= maxFees;
    }
}
