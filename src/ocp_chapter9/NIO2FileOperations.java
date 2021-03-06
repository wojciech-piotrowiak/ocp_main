package ocp_chapter9;

import org.junit.Assert;
import org.junit.Test;
import tools.Helper;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIO2FileOperations {

    @Test
    public void readAllLines() throws IOException {
        final Path path = Paths.get(getFile());
        final List<String> strings = Files.readAllLines(path);
        Assert.assertEquals(3,strings.size());
        Assert.assertEquals("1",strings.get(0));
    }

    @Test
    public void file() throws IOException {
        final Path path = Paths.get(getFile());

        Assert.assertFalse(Files.isSymbolicLink(path));
        Assert.assertTrue(Files.isReadable(path));
        //on mac
        // Assert.assertFalse(Files.isHidden(path));
        //Assert.assertFalse(Files.isExecutable(path));

        //on windows
        Assert.assertTrue(Files.isExecutable(path));
        Assert.assertFalse(Files.isHidden(path));
    }



    private String getFile(){
        return Helper.getResource("chapter/lines.txt");
    }
}
