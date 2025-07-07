package com.rkdev.oop.BankAccountProject;

import java.util.Scanner;

public class ErrorHandler {

    private Scanner scanner;

    public ErrorHandler(Scanner scan) {
        this.scanner = scan;
    }

    Scanner getScan() {
        return this.scanner;
    }

    public int getSafeInt(String message) {
        while(true) {
            System.out.println(message);
            try {
                return scanner.nextInt();
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println("Use the number not the String");
            }
        }
    }

    public double getSafeDouble(String message) {
        while(true) {
            System.out.println(message);
            try {
                return scanner.nextDouble();
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println("Use the number not the String");
            }
        }
    }
}
