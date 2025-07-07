package com.rkdev.oop.BankAccountProject;

public class OverdraftAccount extends BankAccount{
    private double overdraftLimit;

    public OverdraftAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    double gerOverdraftLimit() {
        return this.overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();

        double remainingBalance = currentBalance - amount;

        if (remainingBalance >= -overdraftLimit) {
            setBalance(remainingBalance);
        } else {
            throw new IllegalArgumentException("Insufficient amount");
        }
    }
}
