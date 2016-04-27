package ocp_chapter4.streams.primitive;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class BasicExamples {

    @Test
    public void doubleStreamTest() {
        DoubleStream empty = DoubleStream.empty();
        Assert.assertFalse(empty.average().isPresent());

        DoubleStream doubleStream = DoubleStream.of(3.2);
        double asDouble = doubleStream.findFirst().getAsDouble();
        Assert.assertEquals(3.2, asDouble, 1);
    }

    @Test
    public void rangeExamples() {
        Assert.assertEquals(4, IntStream.range(1, 5).count());
        Assert.assertEquals(5, IntStream.rangeClosed(1, 5).count());

    }
}
