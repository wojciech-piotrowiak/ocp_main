package ocp_chapter4.streams.primitive;


import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.stream.*;


public class MappingExamples {

    //there are methods to map any value to primitive like:
    //mapToDouble, mapToLong, mapToInt
    @Test
    public void mapToPrimitive() {
        DoubleStream doubleStream = getStringStream().mapToDouble(a -> a.length());
        Assert.assertTrue(doubleStream.findFirst().isPresent());

        LongStream longStream = getStringStream().mapToLong(a -> a.length() * 2);
        Assert.assertTrue(longStream.findFirst().isPresent());

        IntStream intStream = getStringStream().mapToInt(a -> a.length() * 4);
        Assert.assertTrue(intStream.findFirst().isPresent());
    }

    //the same kinds of stream can be mapped by map function
    @Test
    public void map() {
        DoubleStream doubleStream = DoubleStream.of(2.2, 4.5);
        double asDouble = doubleStream.map(a -> a * 2).findFirst().getAsDouble();
        Assert.assertEquals(4.4, asDouble, 1);
    }

    //primitive stream can be mapped into object streams
    @Test
    public void mapToObj() {
        DoubleStream doubleStream = DoubleStream.of(2.31, 4.59);
        Stream<Double> objectDoubleStream = doubleStream.mapToObj(a -> a * 2);
        Double aDouble = objectDoubleStream.findFirst().get();
        Assert.assertEquals(Double.valueOf(4.62), aDouble);
    }

    private Stream<String> getStringStream() {
        return Stream.of("1", "D", "2432", "2");
    }
}
