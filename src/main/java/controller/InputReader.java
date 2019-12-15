package controller;

import model.Account;

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

    public Account enterAccountInformation() {
        System.out.print(resourceBundle.getString("acount_number") + ": ");
        String accountNumber = scanner.nextLine();
        System.out.print(resourceBundle.getString("password") + ": ");
        String password = scanner.nextLine();
        Account account = new Account(accountNumber, password);
        return account;
    }
}
