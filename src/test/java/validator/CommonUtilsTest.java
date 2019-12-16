package validator;

import org.junit.Test;
import utils.CommonUtils;

import static org.junit.Assert.*;
public class CommonUtilsTest {

    @Test
    public void testCheckAccountNumber() {
        Validator validator = new Validator();
        assertEquals("true", validator.checkAccountNumber("1234567890"));
        assertEquals("true", validator.checkAccountNumber("1234567450"));
        assertEquals("false",validator.checkAccountNumber("123ff4567890"));
        assertEquals("false",validator.checkAccountNumber("67890"));
    }

    @Test
    public void testCheckPassword() {
        Validator validator = new Validator();
        assertEquals("true", validator.checkPassword("thinhvn123"));
        assertEquals("true", validator.checkPassword("Hungnd6145"));
        assertEquals("true", validator.checkPassword("Thinhvn44545"));
        assertEquals("false", validator.checkPassword("thi"));
        assertEquals("false", validator.checkPassword("123"));
    }

    @Test
    public void testGenerateCaptchar() {
        String captchar1 = CommonUtils.generateCaptcha();
        String captchar2 = CommonUtils.generateCaptcha();
        assertEquals(false, captchar1.equals(captchar2));
    }

}
