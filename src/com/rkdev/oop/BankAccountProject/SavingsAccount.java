package com.rkdev.oop.BankAccountProject;

public class SavingsAccount extends BankAccount{
    private final double INTERESTS;

    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double INTERESTS) {
        super(accountHolderName, accountNumber, balance);
        this.INTERESTS = INTERESTS;
    }

    double getInterests() {
        return this.INTERESTS;
    }

    public double applyInterests(){
        double currentBalance = getBalance();
        double interestAmount = currentBalance * INTERESTS;
        deposit(interestAmount);
        return interestAmount;
    }
}
