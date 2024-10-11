package Guias.guia6.ej4_Bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(int id) {
        super(id);
    }
     protected boolean canExtract(double amount){
        return balance >= amount;
     }
}
