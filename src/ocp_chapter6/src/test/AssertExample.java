import org.junit.BeforeClass;
import org.junit.Test;

public class AssertExample {

    @BeforeClass
    public static void oneTimeSetUp()
    {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
    }

    @Test(expected = AssertionError.class)
    public void assertMe()
    {
        assert 3<2;
    }
}
