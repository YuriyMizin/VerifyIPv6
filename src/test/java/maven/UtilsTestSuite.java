package maven;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 05.12.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        UtilsIsStringIPv6Test.class,
        UtilsCharIsHexTest.class
})
public class UtilsTestSuite {
}