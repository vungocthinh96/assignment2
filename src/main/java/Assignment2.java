import controller.InputReader;
import controller.AccountController;
import validator.Validator;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {

        Assignment2 assignment2 = new Assignment2();
        while (true) {
            assignment2.run();
        }
    }

    public void run() {

        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit program");
        System.out.print("Please choose one option: ");

        ResourceBundle bundle;
        Validator valdator;
        InputReader inputReader;
        AccountController accountController;
        try {
            Scanner scanner = new Scanner(System.in);
            int lang = scanner.nextInt();
            switch (lang) {
                case 1:
                    bundle = ResourceBundle.getBundle("Vi", new Locale("vi", "VN"));
                    inputReader = new InputReader(scanner, bundle);
                    valdator = new Validator();
                    accountController = new AccountController(inputReader, valdator);
                    accountController.login();
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("En", Locale.US);
                    inputReader = new InputReader(scanner, bundle);
                    valdator = new Validator();
                    accountController = new AccountController(inputReader, valdator);
                    accountController.login();
                    break;
                case 3:
                    System.out.println("exit !!!");
                    System.exit(1);
                default:
                    System.out.println("You don't press either number 1, 2 or 3".toUpperCase());
            }
        } catch (InputMismatchException e) {
            System.out.println("you must press a number".toUpperCase() + "\t" + e.getMessage());
        }

    }
}
