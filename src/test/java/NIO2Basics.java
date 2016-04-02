import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;


public class NIO2Basics
{
    @Before
    public void init()
    {
        //prints current file system
        System.out.println(Paths.get("").getFileSystem());
    }

	@Test
	public void toFileTest()
	{
		final Path path = Paths.get("example.txt");
		Assert.assertFalse(path.toFile().exists());
	}

	@Test
	public void absoluteTest()
	{
		final Path path = Paths.get("/example.txt");
        //works on mac
		Assert.assertTrue(path.isAbsolute());
	}

    @Test
    public void parentTest()
    {
        final Path path = Paths.get("/dir/example.txt");
        Assert.assertEquals(path.getParent().toString(),"/dir");
    }
}
