import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIO2FileRead {

    @Test
    public void readAllLines() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource("lines.txt");
        final Path path = Paths.get(resource.getFile());
        final List<String> strings = Files.readAllLines(path);
        Assert.assertEquals(3,strings.size());
    }
}
