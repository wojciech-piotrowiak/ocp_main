package ocp_chapter4;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExamples {
    //Optional is just wrapper for any objects, there is a chance to check if there is any value defined
    //it's good alternative to returning null and checking for nulls

    @Test
    public void optionalEmpty() {
        Optional<String> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());
    }

    @Test
    public void optionalOf() {
        Optional<String> optional = Optional.of("test");
        Assert.assertTrue(optional.isPresent());
    }

    @Test
    public void optionalGet() {
        Optional<String> optional = Optional.of("test");
        Assert.assertEquals("test", optional.get());
    }

    @Test(expected = NoSuchElementException.class)
    public void optionalGetEmpty() {
        Optional<String> empty = Optional.empty();
        //it's recommended to check isPresent before using get


        empty.get();
    }


    @Test(expected = NullPointerException.class)
    public void optionalOfWithNull() {
        //possible null values can be mapped to empty optional with ofNullable method
        Optional.of(null);
    }

    @Test
    public void optionalOfNullable() {
        Optional<String> nullable = Optional.ofNullable(null);
        Assert.assertFalse(nullable.isPresent());
    }

    @Test
    public void optionalIfPresent() {
        //optional values are passed into consumer if option is present
        Optional<String> optional = Optional.ofNullable("print me");
        optional.ifPresent(System.out::print);
    }

    @Test
    public void optionalElseMethods() {
        Optional<String> empty = Optional.ofNullable(null);
        Assert.assertEquals("fallback value", empty.orElse("fallback value"));

        Optional<String> orElseGet = Optional.ofNullable(null);
        //orElseGet uses Supplier to return value
        Assert.assertEquals("fallback value", orElseGet.orElseGet(() -> "fallback value"));
    }

    @Test(expected = IllegalStateException.class)
    public void optionalElseThrow() {
        Optional<String> empty = Optional.ofNullable(null);
        //orElseThrow uses Supplier to get thrown exception
        Assert.assertEquals("fallback value", empty.orElseThrow(() -> new IllegalStateException()));
    }


}
