package controller;

import model.Account;
import utils.Validator;

public class MainController {

    private InputReader inputReader;
    private Validator valdator;

    public MainController(InputReader inputReader, Validator valdator) {
        this.inputReader = inputReader;
        this.valdator = valdator;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public void setInputReader(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Validator getValdator() {
        return valdator;
    }

    public void setValdator(Validator valdator) {
        this.valdator = valdator;
    }

    public void login() {

        boolean checkCaptchar = false;
        boolean check1 = false;

        do {
            Account account1 = inputReader.enterAccountInformation();
            String checkAccountNumber = valdator.checkAccountNumber(account1.getAccountNumber());
            if (!checkAccountNumber.equals("true")) {
                System.out.println(inputReader.getResourceBundle().getString("error_acount_number"));
                continue;
            } else {
                check1 = true;
            }
            String checkPassword = valdator.checkPassword(account1.getPassword());
            if (!checkPassword.equals("true")) {
                System.out.println(inputReader.getResourceBundle().getString("error_password"));
                check1 = false;
                continue;
            }

        } while (!check1);


        while (!checkCaptchar) {
            System.out.print(inputReader.getResourceBundle().getString("captchar") + ": ");
            String captchar = valdator.generateCaptchar();
            System.out.println(captchar);
            System.out.print(inputReader.getResourceBundle().getString("captchar_enter") + ": ");
            String captcharEnter = inputReader.getScanner().nextLine();
            String check = valdator.checkCaptchar(captcharEnter, captchar);
            if (check.equals("true"))
                checkCaptchar = true;
            else {
                System.out.println(inputReader.getResourceBundle().getString("error_captchar"));
            }
        }
    }
}
