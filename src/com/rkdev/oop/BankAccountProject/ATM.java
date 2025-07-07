package com.rkdev.oop.BankAccountProject;

import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    Scanner scan = new Scanner(System.in);

    public void selectAccountType() {
        System.out.println("Выберите тип счета: ");
        System.out.println("1. Сберигательный");
        System.out.println("2. Коммисионный");
        System.out.println("3. Овердрафт");
        System.out.println("4. Вернуться в главное меню");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                account = new SavingsAccount("Robert", "55235", 10000, 0.05);
                break;
            case 2:
                account = new FeeAccount("Robert", "55236", 15000, 0.093);
                break;
            case 3:
                account = new OverdraftAccount("Robert", "55237", 25000, 10000);
                break;
            case 4:
                System.out.println("Всего хорошего");
                return;
            default:
                System.out.println("Неверный выбор.");
        }

        if (account != null) {
            System.out.println("Выбран счет: " + account.getAccountNumber() + ", баланс: " + account.getBalance());
        }
    }

    public void showAccountStatus() {
        if (account != null) {
            System.out.println("Your current account : " + account.getAccountNumber() + ", balance: " + account.getBalance());
        } else {
            System.out.println("The account doesn't chosen");
        }
    }

    public boolean isAccountSelected() {
        if (account == null) {
            System.out.println("Выберите тип счета");
            return false;
        }
        return true;
    }

    public void calculateBonus() {
        if (account instanceof SavingsAccount) {
            SavingsAccount savings = (SavingsAccount) account;
            double bonus = savings.applyInterests();
            System.out.println("Годовой бонус: " + bonus);
        } else {
            System.out.println("Эта опция доступна только для сберегательных счетов");
        }
    }

    public void start() {

        while (true) {
            showAccountStatus();

            System.out.println("\nВыберите действие:");
            System.out.println("1. Выбрать тип счета");
            System.out.println("2. Показать баланс");
            System.out.println("3. Пополнить счёт");
            System.out.println("4. Снять средства");
            System.out.println("5. Расчитать бонус");
            System.out.println("6. Выйти");

            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    selectAccountType();
                    break;
                }
                case 2: {
                    if (!isAccountSelected()) {
                        continue;
                    }
                    System.out.println("Ваш текущий баланс: " + account.getBalance());
                    continue;
                }
                case 3: {
                    if (!isAccountSelected()){
                        continue;
                    }
                    System.out.println("Введите сумму: ");
                    double amount = scan.nextDouble();
                    account.deposit(amount);
                    break;
                }
                case 4: {
                    if (!isAccountSelected()) {
                        continue;
                    }
                    System.out.println("Введите сумму: ");
                    double amount = scan.nextDouble();
                    account.withdraw(amount);
                    break;
                }
                case 5: {
                    if (!isAccountSelected()) {
                        continue;
                    }
                    calculateBonus();
                    break;
                }
                case 6: {
                    System.out.println("Операция завершена");
                    return;
                }
                default: {
                    System.out.println("Неверный выбор.");
                }
            }
        }
    }
}
