package Guias.guia6.ej4_Bank;

import java.util.HashSet;
import java.util.Set;

public class Bank {
    private final Set<BankAccount> accounts = new HashSet<>(); //asegura no tener dos cuentas de banco iguales

    public void addAccount(BankAccount acc){
        accounts.add(acc);
    }

    public int accountSize(){
        return accounts.size();
    }

    public void removeAccount(BankAccount acc){
        accounts.remove(acc);
    }

    public double totalAmount(){
        double ans = 0;
        for (BankAccount ba : accounts){
            ans += ba.getBalance();
        }
        return ans;
    }
}
