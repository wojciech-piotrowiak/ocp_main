package ocp_chapter7;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ParallelStreamExample
{
    @Test
    public void isParallelFasterThanNormal() {
        long normal = filterAndCollect(getStream());
        System.out.print("'Normal' stream " + normal);

        long parallel = filterAndCollect(getStream().parallel());
        System.out.print("'Parallel' stream " + parallel);
        Assert.assertTrue(normal > parallel);
    }

    private long filterAndCollect(Stream<Integer> numbers) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

		final Set<Integer> collect = numbers.filter(i -> i.intValue() > 1).collect(Collectors.toSet());

		stopWatch.stop();
        return stopWatch.getTime();
    }

	private static Stream<Integer> getStream()
	{
		return Stream.of(1, 2, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 0, 0, 4, 4, 4, 4, 4, 4);
	}
}
