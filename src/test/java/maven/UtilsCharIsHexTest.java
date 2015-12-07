package maven;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by User on 05.12.2015.
 */
public class UtilsCharIsHexTest {
    Utils utils = new Utils();

    @Test
    public void test_Positive_0() {
        assertTrue(utils.charIsHex('0'));
    }

    @Test
    public void test_Positive_9() {
        assertTrue(utils.charIsHex('9'));
    }

    @Test
    public void test_Positive_a() {
        assertTrue(utils.charIsHex('a'));
    }

    @Test
    public void test_Positive_A() {
        assertTrue(utils.charIsHex('a'));
    }

    @Test
    public void test_Positive_f() {
        assertTrue(utils.charIsHex('f'));
    }

    @Test
    public void test_Positive_F() {
        assertTrue(utils.charIsHex('F'));
    }

    @Test
    public void test_Negative_g() {
        assertFalse(utils.charIsHex('g'));
    }

    @Test
    public void test_Negative_G() {
        assertFalse(utils.charIsHex('G'));
    }

    @Test
    public void test_Negative_Space() {
        assertFalse(utils.charIsHex(' '));
    }

    @Test
    public void test_Negative_Colon() {
        assertFalse(utils.charIsHex(':'));
    }
}