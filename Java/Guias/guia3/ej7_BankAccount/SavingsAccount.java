package Guias.guia3.ej7_BankAccount;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(int id) {
        super(id);
    }
     protected boolean canExtract(double amount){
        return balance >= amount;
     }
}
