package ocp_chapter1;

import org.junit.Assert;
import org.junit.Test;


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

    @Test
    public void multipleInterfaceInheritance() {
        ItWorks itWorks = new ItWorks();
        Assert.assertEquals("1", itWorks.getText());
        Assert.assertTrue(itWorks instanceof One);
        Assert.assertTrue(itWorks instanceof Two);
    }

    //will not compile, because of default methods
    //class Tested implements one,two
    interface one {
        default String getText() {
            return "1";
        }
    }

    interface two {
        default String getText() {
            return "2";
        }
    }

    class ItWorks implements One, Two {

        @Override
        public String getText() {
            return "1";
        }
    }

    interface One {
        String getText();
    }

    interface Two {
        String getText();
    }


}
