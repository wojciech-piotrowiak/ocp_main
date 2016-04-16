package ocp_chapter7;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;


public class BasicStreamExamples
{
	@Test
	public void basics()
	{
		Assert.assertEquals(7, getStream().count());

		Assert.assertEquals(3, getStream().filter(item -> item > 2).count());

		Assert.assertEquals(5, getStream().distinct().count());

		Assert.assertTrue(getStream().allMatch(item -> item > 0));

		Assert.assertTrue(getStream().anyMatch(item -> item == 5));

		Assert.assertTrue(getStream().noneMatch(item -> item == 0));
	}

	@Test
	public void findFirstFindAny()
	{
		Assert.assertTrue(getStream().findAny().isPresent());
		Assert.assertFalse(getEmptyStream().findAny().isPresent());

		Assert.assertTrue(getStream().findFirst().isPresent());
		Assert.assertEquals(1, getStream().findFirst().get().longValue());
		Assert.assertFalse(getEmptyStream().findFirst().isPresent());
	}

	@Test
	public void skipLimit()
	{
		Assert.assertEquals(1, getStream().skip(6).count());
		Assert.assertEquals(2, getStream().limit(2).count());
	}

	@Test
	public void minMax()
	{
		Assert.assertEquals(5, getStream().max(Comparator.<Integer> naturalOrder()).get().longValue());
		Assert.assertEquals(1, getStream().min(Comparator.<Integer> naturalOrder()).get().longValue());
	}

	@Test
	public void sortWithPeek()
	{
		getStream().peek(System.out::print).sorted().forEach(System.out::print);
	}

	private static Stream<Integer> getStream()
	{
		return Stream.of(1, 5, 2, 2, 3, 4, 1);
	}

	private static Stream<Integer> getEmptyStream()
	{
		return Stream.of();
	}
}
