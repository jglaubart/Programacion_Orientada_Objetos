package Parcial1.P22_09_2022.Ej3_Loan;

import java.time.LocalDate;

public class LastDayLoan extends LastFeeLoan{
    private LocalDate lastPaymentDate;

    public LastDayLoan(long amount, LocalDate loanDate, int fees, Destinatary dest) {
        super(amount, loanDate, fees, dest);
        lastPaymentDate = loanDate;
    }


    @Override
    protected boolean canPay(int numFee, LocalDate date){
        return super.canPay(numFee, date) && date.isAfter(lastPaymentDate);
    }

    @Override
    public void pay(int numFee, LocalDate date){
        super.pay(numFee, date);
        lastPaymentDate = date;
    }

    @Override
    public String toString() {
        return super.toString() + " Next PayDate: After %s.".formatted(lastPaymentDate);
                //Next PayDate: After 2022-09-01.
    }
}
