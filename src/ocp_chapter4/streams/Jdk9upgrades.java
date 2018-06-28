package ocp_chapter4.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class Jdk9upgrades {

	@Test
	public void takeWhileExample() {
		IntStream.range(0, 12).takeWhile(input -> input < 10).forEach(System.out::println);
	}

	@Test
	public void iterateUnaryExamples() {
		Stream.iterate(1, integer -> integer + 1).limit(10).forEach(System.out::println);
		System.out.println("====");
		Stream.iterate(1, integer -> integer * 2).limit(10).forEach(System.out::println);
	}

	@Test
	public void iterateExamples() {
		Stream.iterate(1, x -> x <= 20, x -> ++x).forEach(System.out::println);
	}

	@Test
	public void nullables() {
		Assert.assertEquals(0, Stream.ofNullable(null).count());
		Assert.assertEquals(1, Stream.ofNullable("text").count());
	}
}
