package Parcial1.P22_09_2022.Ej3_Loan;

import java.time.LocalDate;

public class LastFeeLoan extends Loan{
    private int lastFee;

    public LastFeeLoan(long amount, LocalDate loanDate, int fees, Destinatary dest) {
        super(amount, loanDate, fees, dest);
        this.lastFee = 0;
    }


    @Override
    protected boolean canPay(int numFee, LocalDate date){
        return super.canPay(numFee, date) && numFee == lastFee + 1;
    }

    @Override
    public void pay(int numFee, LocalDate date){
        super.pay(numFee, date);
        lastFee = numFee;
    }

    @Override
    public String toString() {
        return super.toString() + " Last quota: %d.".formatted(lastFee);
    }
}
