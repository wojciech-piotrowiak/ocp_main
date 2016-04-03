import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2subpath {

    @Test
    public void subpath()
    {
        final Path path = Paths.get("/top/middle/bottom/example.txt");
        Assert.assertEquals("top", path.subpath(0, 1).toString());
        Assert.assertEquals("top/middle", path.subpath(0, 2).toString());
        Assert.assertEquals("top/middle/bottom", path.subpath(0, 3).toString());
        Assert.assertEquals("middle/bottom", path.subpath(1, 3).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void subpathException()
    {
        final Path path = Paths.get("/top/middle/bottom/example.txt");
        Assert.assertEquals("top", path.subpath(0, 0).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void subpathException2()
    {
        final Path path = Paths.get("/top/middle/bottom/example.txt");
        Assert.assertEquals("top", path.subpath(1, 0).toString());
    }
}
