package com.rkdev.oop.BankAccountProject;

import java.sql.SQLOutput;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolderName, String accountNumber, double balance ) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    String getAccountHolderName() {
        return this.accountHolderName;
    }

    String getAccountNumber() {
        return this.accountNumber;
    }

    double getBalance() {
        return this.balance;
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double showBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Сумма должна быть положительной");

        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("insufficient funds");
        }
    }
}
