package utils;

import java.util.Random;

public class CommonUtils {

    public static String checkAccountNumber(String accountNumber) {
        boolean check = accountNumber.matches("[0-9]+") && accountNumber.length() == 10;
        if(check == true)
            return "true";
        return "false";
    }
    public static String checkPassword(String password) {
        boolean check = password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*") && password.length() >= 8 && password.length() <= 31;
        if(check == true)
            return "true";
        return "false";
    }

    public static String generateCaptchar() {
        char data[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9' };
        char index[] = new char[7];

        Random r = new Random();
        int i = 0;

        for (i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
        }
        return new String(index);
    }

    public static String checkCaptchar(String captcharInput, String captcharGenerate) {
        if(captcharInput.equals(captcharGenerate))
            return "true";
        return "false";
    }
}
