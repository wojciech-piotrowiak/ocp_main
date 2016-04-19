package ocp_chapter4.functionalinterfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionsExample {
    //function have to return single value and accept single value on input
    //bifunction accept two parametrs
    @Test
    public void functionTest() {
        Function<String, Integer> stringLength = (a) -> a.length();
        Function<Integer, Integer> doubleValue = (a) -> a * 2;

        Assert.assertEquals(new Integer(5), stringLength.apply("23142"));
        Assert.assertEquals(new Integer(4), doubleValue.apply(2));
    }

    @Test
    public void biFunctionTest() {
        BiFunction<String, String, String> concatenate = (a, b) -> a + b;
        Assert.assertEquals("abc123", concatenate.apply("abc", "123"));
    }
}
