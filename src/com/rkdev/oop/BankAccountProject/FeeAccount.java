package com.rkdev.oop.BankAccountProject;

public class FeeAccount extends BankAccount {
    private double fee;

    public FeeAccount(String accountHolderName, String accountNumber, double balance, double fee) {
        super(accountHolderName, accountNumber, balance);
        this.fee = fee;
    }

    double getFee() {
        return this.fee;
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        double appliedFee = amount * fee;

        if (currentBalance < (amount + appliedFee)) throw new IllegalArgumentException("Insufficient amount");

        super.withdraw(amount);
        super.withdraw(appliedFee);
    }
}
