package ocp_chapter4.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
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
}
