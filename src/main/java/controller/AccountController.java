package controller;

import model.Account;
import utils.CommonUtils;
import validator.Validator;

public class AccountController {

    private InputReader inputReader;
    private Validator validator;

    public AccountController(InputReader inputReader, Validator validator) {
        this.inputReader = inputReader;
        this.validator = validator;
    }

    public void login() {

        boolean checkCaptcha = false;
        boolean check1 = false;

        do {
            Account account1 = inputReader.getAccountInformation();
            boolean checkAccountNumber = validator.checkAccountNumber(account1.getAccountNumber());
            if (!checkAccountNumber) {
                System.out.println(inputReader.getResourceBundle().getString("error_acount_number"));
                continue;
            } else {
                check1 = true;
            }
            boolean checkPassword = validator.checkPassword(account1.getPassword());
            if (!checkPassword) {
                System.out.println(inputReader.getResourceBundle().getString("error_password"));
                check1 = false;
                continue;
            }

        } while (!check1);


        while (!checkCaptcha) {
            System.out.print(inputReader.getResourceBundle().getString("captchar") + ": ");
            String captcha = CommonUtils.generateCaptcha();
            System.out.println(captcha);
            System.out.print(inputReader.getResourceBundle().getString("captchar_enter") + ": ");
            String captchaEnter = inputReader.inputCaptcha();
            boolean check = validator.checkCaptchar(captchaEnter, captcha);
            if (check)
                checkCaptcha = true;
            else {
                System.out.println(inputReader.getResourceBundle().getString("error_captchar"));
            }
        }
    }


}
