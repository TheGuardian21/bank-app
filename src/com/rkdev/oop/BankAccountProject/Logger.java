package com.rkdev.oop.BankAccountProject;

import java.util.*;
import java.time.LocalDateTime;

public class Logger {
    private List<String> logs = new ArrayList<>();

    public Logger() {

    }

    public void logInfo(String message) {
        LocalDateTime now = LocalDateTime.now();
        String logMessage = ("[INFO] " + now + " - " + message);
        logs.add(logMessage);
    }

    public void logError(String message) {
        LocalDateTime now = LocalDateTime.now();
        String logMessage = ("[ERROR] " + now + " - " + message);
        logs.add(logMessage);
    }

    public void logWarn(String message) {
        LocalDateTime now = LocalDateTime.now();
        String logMessage = ("[WARN] " + now + " - " + message);
        logs.add(logMessage);
    }

    public void printLog() {
        if (logs.isEmpty()) {
            System.out.println("Log Is Empty");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    public void clearLog() {
        logs.clear();
        System.out.println("The log is empty now");
    }
}
