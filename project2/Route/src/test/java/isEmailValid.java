import org.junit.Test;
import forTest.ForTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by efischenko on 21.06.2017.
 */
public class isEmailValid {
    public static String email1 = "Elochka";
    public static String email2 = "iamfischenko@mail.com";
    public static String email3 = "f..../6%34!!!@..mail.com";


    @Test
    public void isRightEmailValid1() throws Exception {
        assertFalse(ForTest.isEmailValid(email1));
    }
    @Test
    public void isRightEmailValid2() throws Exception {
        assertTrue(ForTest.isEmailValid(email2));
    }
    @Test
    public void isRightEmailValid3() throws Exception {
        assertFalse(ForTest.isEmailValid(email3));
    }
}
