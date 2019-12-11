package utils;

import org.junit.Test;
import static org.junit.Assert.*;
public class CommonUtilsTest {

    @Test
    public void testCheckAccountNumber() {
        assertEquals("true", CommonUtils.checkAccountNumber("1234567890"));
        assertEquals("true", CommonUtils.checkAccountNumber("1234567450"));
        assertEquals("false", CommonUtils.checkAccountNumber("123ff4567890"));
        assertEquals("false", CommonUtils.checkAccountNumber("67890"));
    }

    @Test
    public void testCheckPassword() {
        assertEquals("true", CommonUtils.checkPassword("thinhvn123"));
        assertEquals("true", CommonUtils.checkPassword("Hungnd6145"));
        assertEquals("true", CommonUtils.checkPassword("Thinhvn44545"));
        assertEquals("false", CommonUtils.checkPassword("thi"));
        assertEquals("false", CommonUtils.checkPassword("123"));
    }

    @Test
    public void testGenerateCaptchar() {
        String captchar1 = CommonUtils.generateCaptchar();
        String captchar2 = CommonUtils.generateCaptchar();
        assertEquals(false, captchar1.equals(captchar2));
    }

}
