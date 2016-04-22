package ocp_chapter4.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperationExamples {

    @Test(expected = IllegalStateException.class)
    public void usageOfTerminatedStream() {
        Stream<String> stringStream = Stream.of("1", "2");
        stringStream.count();
        //cannot perform second termination statement because stream is closed permamently
        stringStream.count();
    }

    @Test
    public void count() {
        //reduction yes
        //does not terminate for infinite
        Stream<String> stream = Stream.of("a1", "a2");
        Assert.assertEquals(2, stream.count());
    }

    @Test
    public void minMax() {
        //reduction yes
        //does not terminate for infinite
        Stream<Integer> maxStream = Stream.of(1, 4, 4, 2, 3);
        Optional<Integer> max = maxStream.max((s1, s2) -> s1 - s2);
        Assert.assertEquals(4, max.get().intValue());

        Stream<Integer> minStream = Stream.of(1, 4, 4, 2, 3);
        Optional<Integer> min = minStream.max((s1, s2) -> s2 - s1);
        Assert.assertEquals(1, min.get().intValue());
    }

    @Test
    public void findAnyFindFirst() {
        //reduction no
        //terminates infinite stream
        Stream<Integer> findAny = Stream.of(1, 4, 4, 2, 3);
        Assert.assertTrue(findAny.findAny().isPresent());
        Assert.assertFalse(Stream.empty().findAny().isPresent());

        Stream<String> findFirst = Stream.of("A", "B", "C");
        Assert.assertEquals("A", findFirst.findFirst().get());
        Assert.assertFalse(Stream.empty().findFirst().isPresent());
    }

    @Test
    public void matchExamples() {
        //sometimes terminates infinite stream
        //reduction no

        Predicate<String> predicate = x -> x.contains("X");

        Stream<String> allMatch = Stream.of("XA", "BX", "CX", "XX");
        Assert.assertTrue(allMatch.allMatch(predicate));

        Stream<String> anyMatch = Stream.of("XA", " ", "", "CC");
        Assert.assertTrue(anyMatch.anyMatch(predicate));

        Stream<String> noneMatch = Stream.of("CCC", " ", "", "BBB");
        Assert.assertTrue(noneMatch.noneMatch(predicate));
    }

    @Test
    public void forEach() {
        //no reduction
        //do not terminate infinite stream
        //accept consumer on input
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        stream.forEach(System.out::println);
    }

    @Test
    public void reduce() {
        //does not terminate infinite stream
        //reduction:yes
        BinaryOperator<Integer> op = (a, b) -> a + b;
        Stream<Integer> stream = Stream.of(1, 4, 4, 2, 3);
        Assert.assertEquals(14, stream.reduce(op).get().intValue());
    }
}
