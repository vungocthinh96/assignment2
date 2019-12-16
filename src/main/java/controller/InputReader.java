package controller;

import model.Account;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;
    private ResourceBundle resourceBundle;

    public InputReader(Scanner scanner, ResourceBundle resourceBundle) {
        this.scanner = scanner;
        this.resourceBundle = resourceBundle;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public Account getAccountInformation() {
        System.out.print(resourceBundle.getString("acount_number") + ": ");
        String accountNumber = scanner.next();
        System.out.print(resourceBundle.getString("password") + ": ");
        String password = scanner.next();
        Account account = new Account(accountNumber, password);
        return account;
    }

    public String inputCaptcha() {
        String captcha = "";
        try {
            captcha = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return captcha;
    }
}
