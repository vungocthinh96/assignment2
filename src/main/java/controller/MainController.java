package controller;

import model.Account;
import utils.CommonUtils;

import java.util.ResourceBundle;
import java.util.Scanner;

public class MainController {
    private ResourceBundle resourceBundle;
    private Scanner scanner;

    public MainController(ResourceBundle resourceBundle, Scanner scanner) {
        this.resourceBundle = resourceBundle;
        this.scanner = scanner;
    }

    public void login() {

        boolean checkAccount = false;
        boolean checkPassword = false;
        boolean checkCaptchar = false;

        while(!checkAccount) {
            System.out.print(resourceBundle.getString("acount_number") + ": ");
            String account = scanner.nextLine();
            String check = CommonUtils.checkAccountNumber(account);
            if(check.equals("true"))
                checkAccount = true;
            else {
                System.out.println(resourceBundle.getString("error_acount_number"));
            }
        }

        while(!checkPassword) {
            System.out.print(resourceBundle.getString("password") + ": ");
            String password = scanner.nextLine();
            String check = CommonUtils.checkPassword(password);
            if(check.equals("true"))
                checkPassword = true;
            else {
                System.out.println(resourceBundle.getString("error_password"));
            }
        }

        while(!checkCaptchar) {
            System.out.print(resourceBundle.getString("captchar") + ": ");
            String captchar = CommonUtils.generateCaptchar();
            System.out.println(captchar);
            System.out.print(resourceBundle.getString("captchar_enter")+": ");
            String captcharEnter = scanner.nextLine();
            String check = CommonUtils.checkCaptchar(captcharEnter, captchar);
            if(check.equals("true"))
                checkCaptchar = true;
            else {
                System.out.println(resourceBundle.getString("error_captchar"));
            }
        }
    }
}
