import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class NIO2Attribute_vs_View {

    @Test
    public void isViewReallyFasterThanSingleCalls() throws IOException {
        System.out.println(attributeCalls());
        System.out.println(viewCall());
        Assert.assertTrue(attributeCalls() > viewCall());
    }

    private long attributeCalls() {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Path path = Paths.get(getFile());
        File file = path.toFile();
        file.isDirectory();
        file.lastModified();
        file.length();
        file.canRead();
        file.isHidden();
        file.exists();

        stopWatch.stop();
        return stopWatch.getTime();
    }

    private long viewCall() throws IOException {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        DosFileAttributeView view = Files.getFileAttributeView(Paths.get(getFile()), DosFileAttributeView.class);
        DosFileAttributes basicFileAttributes = view.readAttributes();
        basicFileAttributes.isDirectory();
        basicFileAttributes.lastModifiedTime();
        basicFileAttributes.size();
        basicFileAttributes.creationTime();
        basicFileAttributes.isReadOnly();
        basicFileAttributes.isHidden();
        view.readAttributes().
        stopWatch.stop();

        return stopWatch.getTime();
    }

    private String getFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResource("lines.txt").getFile().substring(1);
    }
}
