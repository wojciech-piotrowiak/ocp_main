package ocp_chapter4.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StreamCreationExamples
{

	@Test
	public void array()
	{
		Integer[] arr = { 1, 2, 5, 3, 1, 8, 0 };
        final Stream<Integer> arr1 = Stream.of(arr);
        Assert.assertEquals(arr1.count(), 7);
    }

    @Test
    public void collection()
    {
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("three");
        list.add("two");
        Assert.assertEquals(list.stream().count(), 3);
    }

    @Test
    public void generate()
    {
        //generate creates infinite stream
        Assert.assertEquals(getLimitedXStream().findFirst().get(),"X");
        //when stream is terminate then it's not possible to use it second time
        Assert.assertEquals(getLimitedXStream().count(), 2);
    }

    @Test
    public void iterate()
    {
        //generate creates infinite stream
        Assert.assertEquals(getLimitedIterationStream().findFirst().get().longValue(),0L);
        Assert.assertEquals(getLimitedIterationStream().skip(1).findFirst().get().longValue(),2L);
        Assert.assertEquals(getLimitedIterationStream().count(), 3);
    }

    public Stream<String> getLimitedXStream() {
        return Stream.generate(() -> "X").limit(2);
    }

    public Stream<Integer> getLimitedIterationStream() {
        return Stream.iterate(0, item -> item + 2).limit(3);
    }
}
