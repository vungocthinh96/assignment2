package controller;

import model.Account;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        int lang = 0;
        Scanner scanner = new Scanner(System.in);
        ResourceBundle bundle;
        MainController mainController;
        do {
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit program");
            System.out.print("Please choose one option: ");
            lang = scanner.nextInt();
            switch (lang) {
                case 1:
                    bundle = ResourceBundle.getBundle("Vi", new Locale("vi", "VN"));
                    mainController = new MainController(bundle, scanner);
                    mainController.login();
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("En", Locale.US);
                    mainController = new MainController(bundle, scanner);
                    mainController.login();
                    break;
            }
        } while(lang != 3);
    }
}
