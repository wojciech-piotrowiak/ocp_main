package ocp_chapter9;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;


public class NIO2Basics
{
    @BeforeClass
    public static void init()
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
		final Path path = Paths.get("example.txt");
        //works on mac
		//Assert.assertTrue(path.isAbsolute());
		//
        Assert.assertFalse(path.isAbsolute());
	}

    @Test
    public void parentTest()
    {
        final Path path = Paths.get("\\dir\\example.txt");
        Assert.assertEquals(path.getParent().toString(),"\\dir");
    }

    @Test
    public void fileNameTest()
    {
        final Path path = Paths.get("\\dir\\example.txt");
        Assert.assertEquals(path.getFileName().toString(),"example.txt");
    }

    @Test
    public void fileNameCountTest() {
        final Path path = Paths.get("\\dir\\example.txt");
        Assert.assertEquals(path.getNameCount(), 2);
        Assert.assertEquals(path.getName(0).toString(), "dir");

    }

    @Test
    public void fileRootTest()
    {
        final Path path = Paths.get("\\root\\dir\\example.txt");
        //on mac
        //Assert.assertEquals(path.getRoot().toString(),"/");

        //on windows
        Assert.assertEquals(path.getRoot().toString(),"\\");
    }

    @Test
    public void pathEquals() {
        final Path path1 = Paths.get("root", "dir", "example.txt");
        final Path path2 = Paths.get("\\root\\dir\\example.txt");

        //equals does not check real files
        Assert.assertFalse(path1.equals(path2));
    }

    @Test
    public void resolve() {
        final Path path1 = Paths.get("/X_x");
        final Path path2 = Paths.get("9999example.txt");

        //resolve does not check real files
        Assert.assertEquals("/X_x/9999example.txt", path1.resolve(path2).toString());
    }
}
