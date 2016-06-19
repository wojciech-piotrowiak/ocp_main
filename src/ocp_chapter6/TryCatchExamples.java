package ocp_chapter6;

import org.junit.Test;

public class TryCatchExamples {

    @Test
    public void test() {
        try {

        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {   //it's forbidden to reassign value with multicatch
            //e=new NullPointerException();
        }
    }
}
