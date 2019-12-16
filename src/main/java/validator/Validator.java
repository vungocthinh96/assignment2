package validator;

public class Validator {

    public boolean checkAccountNumber(String accountNumber) {
        boolean check = false;
        try {
            check = accountNumber.matches("[0-9]+") && accountNumber.length() == 10;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(check)
            return true;
        return false;
    }
    public boolean checkPassword(String password) {
        boolean check = false;
        try {
            check = password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*") && password.length() >= 8 && password.length() <= 31;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(check)
            return true;
        return false;
    }

    public boolean checkCaptchar(String captchaInput, String captchaGenerate) {
        if(captchaInput.equals(captchaGenerate))
            return true;
        return false;
    }
}
