package ocp_chapter9;

import org.junit.Assert;
import org.junit.Test;
import tools.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2SearchAndWalk {

    @Test
    public void walk() throws IOException {
        Path path = Paths.get(Helper.getResource("chapter9/searchme"));
        Assert.assertEquals(4,Files.walk(path).filter(p->p.toString().endsWith(".txt")).peek(System.out::println).count());
    }

    @Test
    public void walkWithDepth() throws IOException {
        Path path = Paths.get(Helper.getResource("chapter9/searchme"));
        Assert.assertEquals(2,Files.walk(path,1).filter(p->p.toString().endsWith(".txt")).peek(System.out::println).count());
    }

    @Test
    public void listFiles() throws IOException {
        Path path = Paths.get(Helper.getResource("chapter9/searchme"));
        Assert.assertEquals(3,Files.list(path).
                map(p->p.toAbsolutePath()).peek(System.out::println).count());
    }
}
