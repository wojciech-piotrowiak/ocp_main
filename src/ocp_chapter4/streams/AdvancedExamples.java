package ocp_chapter4.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wpiotrowiak on 23.05.16.
 */
public class AdvancedExamples {
    @Test
    public void linkingData() {
        List<String> stringList = new ArrayList();
        stringList.add("A");
        Stream<String> stream = stringList.stream();
        stringList.add("B");
        Assert.assertEquals(2, stream.count());
    }

    @Test
    public void optional() {
        Optional<String> opt = Optional.of("ABC");
        Optional<String> none = Optional.empty();

        opt.map(o -> o.toLowerCase()).ifPresent(System.out::print);
        //print abc

        none.map(o -> o.toLowerCase()).ifPresent(System.out::print);
        //do not print
    }

    @Test
    public void collectorExamples() {
        Stream<String> str = Stream.of("a", "b", "c");
        String collect = str.collect(Collectors.joining("|"));
        Assert.assertEquals("a|b|c", collect);

        Stream<String> nameStream = Stream.of("kate", "jonh", "lucy");
        Double collect1 = nameStream.collect(Collectors.averagingInt(String::length));
        Assert.assertEquals(4, collect1.intValue());
    }

    @Test
    public void partitioningBy() {
        Stream<String> str = Stream.of("a", "bb");
        Map<Boolean, List<String>> collect = str.collect(Collectors.partitioningBy(s -> s.length() == 1));
        Assert.assertTrue(collect.get(true).contains("a"));
        Assert.assertTrue(collect.get(false).contains("bb"));

        //keys with empty list are created
        Stream<String> empty = Stream.empty();
        Map<Boolean, List<String>> collectEmpty = empty.collect(Collectors.partitioningBy(s -> s.length() == 1));
        Assert.assertTrue(collectEmpty.get(true).isEmpty());
        Assert.assertTrue(collectEmpty.get(false).isEmpty());
    }

    @Test
    public void groupingBy() {
        Stream<String> str = Stream.of("a", "bb");
        Map<Boolean, List<String>> collect = str.collect(Collectors.groupingBy(s -> s.length() == 1));
        Assert.assertTrue(collect.get(true).contains("a"));
        Assert.assertTrue(collect.get(false).contains("bb"));

        //keys are not created
        Stream<String> empty = Stream.empty();
        Map<Boolean, List<String>> collectEmpty = empty.collect(Collectors.groupingBy(s -> s.length() == 1));
        Assert.assertNull(collectEmpty.get(true));
        Assert.assertNull(collectEmpty.get(false));
    }

}
