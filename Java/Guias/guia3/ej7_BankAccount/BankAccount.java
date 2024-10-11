package Guias.guia3.ej7_BankAccount;

public abstract class BankAccount {
    private int id;
    protected double balance;

    public BankAccount(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    protected abstract boolean canExtract(double amount);

    public double extract(double amount) {
        if (canExtract(amount)) {
            this.balance -= amount;
            return this.balance;
        } else {
            System.out.println("Insufficient balance");
            return this.balance;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cuenta %d con saldo %.2f".formatted(this.id, this.balance);
    }
}
