package ocp_chapter4.functionalinterfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryExamples {

    //unary operations are similar to function however unary always accept and return THE SAME type!

    @Test
    public void unaryTest() {
        UnaryOperator<String> postfix = (a) -> a + "postfix";
        UnaryOperator<Integer> increment = (a) -> a + 1;

        Assert.assertEquals("valuepostfix", postfix.apply("value"));
        Assert.assertEquals(new Integer(2), increment.apply(1));
    }

    @Test
    public void BinaryTest() {
        BinaryOperator<String> middlePart = (a, b) -> a + "middle" + b;
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        Assert.assertEquals("pre middle post", middlePart.apply("pre ", " post"));
        Assert.assertEquals(new Integer(7), sum.apply(1, 6));
    }
}
