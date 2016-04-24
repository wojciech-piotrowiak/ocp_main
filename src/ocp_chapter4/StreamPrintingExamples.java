package ocp_chapter4;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPrintingExamples {
    @Test
    public void infiniteStreamSolution() {
        Stream.generate(() -> "input").limit(10).forEach(System.out::println);
    }

    //finite stream examples
    @Test(expected = IllegalStateException.class)
    public void forEachExample() {
        Stream<Integer> forEachExample = Stream.of(1, 3, 4);
        forEachExample.forEach(System.out::print);
        //for each close stream
        forEachExample.count();
    }

    @Test(expected = IllegalStateException.class)
    public void collectorSolution() {
        Stream<String> a = Stream.of("A", "b", "F");
        System.out.println(a.collect(Collectors.toList()));
        //collect also close stream
        a.count();
    }

    @Test
    public void peekSolution() {
        Stream<? extends Number> stream = Stream.of(1.2, 4.4, 9);
        //it's possible to run count after printing
        stream.peek(System.out::println).count();
    }
}
