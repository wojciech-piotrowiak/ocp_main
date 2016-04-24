package ocp_chapter4;


import org.junit.Test;

import java.util.stream.Stream;

public class PipelineExamples {
    @Test(timeout = 500)
    public void sortedOnInfiniteStreamWrong() {
        //generate() produce infinite stream so its not possible to sort it
        Stream.generate(() -> "test").sorted().limit(2);
    }

    @Test
    public void sortedOnInfiniteStreamOK() {
        Stream.generate(() -> "test").limit(2).sorted().forEach(System.out::println);
    }

    @Test(timeout = 500)
    public void limitOnInfiniteStreamWrong() {
        //limit waits for elements,in this example will wait forever
        Stream.generate(() -> "test").filter(a -> a.isEmpty()).limit(2);
    }

}
