package ocp_chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wpiotrowiak on 07.11.16.
 */

//last implementation wins. It's not possible to implement two interfaces with identical default method at the same class.
public class ExamHints implements ExampleInterface1 {

    @Test
    public void test() {
        Assert.assertEquals("I'm first", getText());
    }

}
