package Parcial1.P22_09_2022.Ej3_Loan;

import Teorica.Dates.Date;

import java.time.LocalDate;

public class Loan {
    private long amount;
    private LocalDate loanDate;
    private int remainingFees;
    Destinatary destinatary;

    public Loan(long amount, LocalDate loanDate, int fees, Destinatary dest) {
        if(!dest.canLoan(amount, fees)){
            throw new LoanException("Invalid Loan.");
        }
        this.amount = amount;
        this.loanDate = loanDate;
        this.remainingFees = fees;
        this.destinatary = dest;
    }

    protected boolean canPay(int numFee, LocalDate date){
        return remainingFees > 0 && date.isAfter(loanDate);
    }

    public void pay(int numFee, LocalDate date){
        if(!canPay(numFee, date)){
            throw new LoanException("Cannot pay.");
        }
        System.out.printf("Paying quota %d on date %s\n",numFee, date);
        remainingFees--;
    }

    @Override
    public String toString() {
        // PERSONAL Loan of $1000. Remaining quota: 3
        return "%s Loan of $%d. Remaining quota: %d.".formatted(destinatary, amount, remainingFees);
    }
}
