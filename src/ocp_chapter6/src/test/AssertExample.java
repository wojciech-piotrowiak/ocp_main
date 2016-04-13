import org.junit.BeforeClass;
import org.junit.Test;

public class AssertExample {
//depednds on -ea -da /enable,disable flags in your java configuration
    @Test
    public void defaultAssertBehaviour() {
        assert 3 < 2;
    }

    @Test(expected = AssertionError.class)
    public void assertsEnabled() {
        //magic trick to turn on assertions
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        assert 3 < 2;
    }


}
