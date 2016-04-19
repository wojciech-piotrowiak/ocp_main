package ocp_chapter4.functionalinterfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicatesExample {
    //predicates return boolean values and accept one or two parameters
    @Test
    public void predicateTest() {
        Predicate<String> isLongEnough = (a) -> a.length() > 10;
        Predicate<String> isEmpty = String::isEmpty;

        Assert.assertTrue(isLongEnough.test("long example test"));
        Assert.assertTrue(isEmpty.test(""));
    }

    @Test
    public void biPredicateTest() {
        BiPredicate<String, Integer> isStringExactlyLong = (a, b) -> a.length() == b;
        Assert.assertTrue(isStringExactlyLong.test("123", 3));
    }
}
