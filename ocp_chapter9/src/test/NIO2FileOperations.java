import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIO2FileOperations {

    @Test
    public void readAllLines() throws IOException {
        final Path path = Paths.get(getFile().getFile().substring(1));
        final List<String> strings = Files.readAllLines(path);
        Assert.assertEquals(3,strings.size());
        Assert.assertEquals("1",strings.get(0));
    }

    @Test
    public void file() throws IOException {
        final Path path = Paths.get(getFile().getFile().substring(1));

        Assert.assertFalse(Files.isSymbolicLink(path));
        Assert.assertTrue(Files.isReadable(path));
        //on mac
        //Assert.assertFalse(Files.isExecutable(path));
        Assert.assertTrue(Files.isExecutable(path));
        Assert.assertFalse(Files.isHidden(path));
    }



    private URL getFile(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResource("lines.txt");
    }
}
