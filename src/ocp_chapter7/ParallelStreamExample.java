package ocp_chapter7;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ParallelStreamExample
{

	public static void main(String... args)
	{
		System.out.print("'Normal' stream ");
		filterAndCollect(getStream());

		System.out.print("'Parallel' stream ");
		filterAndCollect(getStream().parallel());
	}

	private static void filterAndCollect(Stream<Integer> numbers)
	{
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

		final Set<Integer> collect = numbers.filter(i -> i.intValue() > 1).collect(Collectors.toSet());

		stopWatch.stop();
		System.out.println(stopWatch.getTime());
	}

	private static Stream<Integer> getStream()
	{
		return Stream.of(1, 2, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 0, 0, 4, 4, 4, 4, 4, 4);
	}
}
