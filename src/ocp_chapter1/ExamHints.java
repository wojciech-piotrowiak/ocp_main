package ocp_chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wpiotrowiak on 11.06.16.
 */
public class ExamHints {
    @Test
    public void instanceofExamples() {
        String a = "";
        //yes it will compile!
        if (null instanceof String) {
        }

        //always true, does matter witch type will be used
        if (a instanceof Comparable) {
            Assert.assertTrue(true);

        }
    }

}
