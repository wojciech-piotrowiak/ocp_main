package ocp_chapter4.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationExamples {

    @Test
    public void filter() {
        Assert.assertEquals(3, getStream().filter(item -> item > 2).count());
    }

    @Test
    public void distinct() {
        Assert.assertEquals(5, getStream().distinct().count());
    }

    @Test
    public void skipLimit() {
        Assert.assertEquals(1, getStream().skip(6).count());
        getStream().skip(6).forEach(System.out::println);
        //last item to print


        Assert.assertEquals(2, getStream().limit(2).count());
        getStream().limit(2).forEach(System.out::println);
        //first two items to print
    }

    @Test
    public void map() {
        List<String> collect = getStream().map(x -> x.toString()).collect(Collectors.toList());
        //maps perform convertion from one type to another
        Assert.assertEquals(7, collect.size());
    }

    @Test
    public void flatMap() {
        List<Integer> emptyOne = Arrays.asList();
        List<Integer> firstOne = Arrays.asList(1, 2);
        List<Integer> secondOne = Arrays.asList(4, 7);
        List<Integer> thirdOne = Arrays.asList(0, 2, 0, 4);
        Stream<List<Integer>> listsStream = Stream.of(emptyOne, firstOne, secondOne, thirdOne);
        List<Integer> collect = listsStream.flatMap(l -> l.stream()).collect(Collectors.toList());

        Assert.assertEquals(8, collect.size());
    }

    @Test
    public void sorted() {
        List<Integer> sorted = getStream().sorted().collect(Collectors.toList());
        Assert.assertEquals(1, sorted.get(0).intValue());
        Assert.assertEquals(5, sorted.get(6).intValue());

        //sorted might accept Comparator
        List<Integer> sortedInReversedWay = getStream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(5, sortedInReversedWay.get(0).intValue());
        Assert.assertEquals(1, sortedInReversedWay.get(6).intValue());
    }

    @Test
    public void peek() {
        //usefull for debugging
        getStream().peek(System.out::println).sorted().forEach(System.out::println);
    }

    private static Stream<Integer> getStream() {
        return Stream.of(1, 5, 2, 2, 3, 4, 1);
    }
}
