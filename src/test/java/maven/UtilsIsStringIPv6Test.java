package maven;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by User on 05.12.2015.
 */
public class UtilsIsStringIPv6Test {
    Utils utils = new Utils();

    @Test
    public void testNegative_Empty() {
        assertFalse(utils.isStringIPv6(""));
    }

    @Test
    public void testNegative_Space() {
        assertFalse(utils.isStringIPv6(" "));
    }

    @Test
    public void testNegative_0() {
        assertFalse(utils.isStringIPv6("0"));
    }

    @Test
    public void testNegative_9() {
        assertFalse(utils.isStringIPv6("9"));
    }

    @Test
    public void testNegative_a() {
        assertFalse(utils.isStringIPv6("a"));
    }

    @Test
    public void testNegative_A() {
        assertFalse(utils.isStringIPv6("A"));
    }

    @Test
    public void testNegative_f() {
        assertFalse(utils.isStringIPv6("f"));
    }

    @Test
    public void testNegative_F() {
        assertFalse(utils.isStringIPv6("F"));
    }

    @Test
    public void testNegative_Semicolon() {
        assertFalse(utils.isStringIPv6(";"));
    }

    @Test
    public void testNegative_Colon() {
        assertFalse(utils.isStringIPv6(":"));
    }

    @Test
    public void testNegative_OneGroupLeftColon() {
        assertFalse(utils.isStringIPv6(":0"));
    }

    @Test
    public void testNegative_OneGroupRightColon() {
        assertFalse(utils.isStringIPv6("FFFF:"));
    }

    @Test
    public void testNegative_TwoGroups() {
        assertFalse(utils.isStringIPv6("5B0e:07fA"));
    }

    @Test
    public void testPositive_DoubleColon() {
        assertTrue(utils.isStringIPv6("::"));
    }

    @Test
    public void testPositive_DoubleColonGroup() {
        assertTrue(utils.isStringIPv6("::0000"));
    }

    @Test
    public void testPositive_GroupDoubleColon() {
        assertTrue(utils.isStringIPv6("ffff::"));
    }

    @Test
    public void testPositive_GroupDoubleColonGroup() {
        assertTrue(utils.isStringIPv6("ffff::0"));
    }

    @Test
    public void testNegative_ThreeColons() {
        assertFalse(utils.isStringIPv6(":::"));
    }

    @Test
    public void testNegative_FourColons() {
        assertFalse(utils.isStringIPv6("::::"));
    }

    @Test
    public void testNegative_DoubleColonGroupDoubleColon() {
        assertFalse(utils.isStringIPv6("::0a9F::"));
    }

    @Test
    public void testNegative_7Groups() {
        assertFalse(utils.isStringIPv6("0:0:0:0:0:0:0"));
    }

    @Test
    public void testPositive_8GroupsZeroes() {
        assertTrue(utils.isStringIPv6("0:0:0:0:0:0:0:0"));
    }

    @Test
    public void testPositive_8GroupsFFFF() {
        assertTrue(utils.isStringIPv6("FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF"));
    }

    @Test
    public void testNegative_WrongDigit() {
        assertFalse(utils.isStringIPv6("0:0:0:0:G:0:0:0"));
    }

    @Test
    public void testNegative_9Groups() {
        assertFalse(utils.isStringIPv6("0:0:0:0:0:0:0:0:0"));
    }

    @Test
    public void testPositive_LeftSuppressed6Groups() {
        assertTrue(utils.isStringIPv6("::0:0:0:0:0:0"));
    }

    @Test
    public void testPositive_RightSuppressed6Groups() {
        assertTrue(utils.isStringIPv6("0:0:0:0:0:0::"));
    }

    @Test
    public void testPositive_6GroupsSuppressedInside() {
        assertTrue(utils.isStringIPv6("0:0:0::0:0:0"));
    }

    @Test
    public void testNegative_8GroupsLeftColon() {
        assertFalse(utils.isStringIPv6(":0:0:0:0:0:0:0:0"));
    }

    @Test
    public void testNegative_8GroupsRightColon() {
        assertFalse(utils.isStringIPv6("0:0:0:0:0:0:0:0:"));
    }

    @Test
    public void testNegative_7GroupsDoubleColon() {
        assertFalse(utils.isStringIPv6("::0:0:0:0:0:0:0"));
    }

    @Test
    public void testNegative_5DigitsRightGroup() {
        assertFalse(utils.isStringIPv6("0:0:0:0:0:0:0:00000"));
    }

    @Test
    public void testNegative_5DigitsLeftGroup() {
        assertFalse(utils.isStringIPv6("00000:0:0:0:0:0:0:0"));
    }

    @Test
    public void testNegative_5DigitsInside() {
        assertFalse(utils.isStringIPv6("0:0:0:0:00000:0:0:0"));
    }
}