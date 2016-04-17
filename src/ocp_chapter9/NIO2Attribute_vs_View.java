package ocp_chapter9;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;
import tools.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

public class NIO2Attribute_vs_View {

    @Test
    public void isViewReallyFasterThanSingleCalls() throws IOException {
        long attributeCalls=0;
        long viewcalls=0;
        Path file = Paths.get(Helper.getResource("chapter9/lines.txt"));
        for(int i=0;i<30;i++)
        {
            attributeCalls+=attributeCall(file);
            viewcalls+=viewCall(file);
        }

        Path file2 = Paths.get(Helper.getResource("chapter9/lines2.txt"));
        for(int i=0;i<30;i++)
        {
            attributeCalls+=attributeCall(file2);
            viewcalls+=viewCall(file2);
        }
        //it depends on file system used
        Assert.assertTrue(attributeCalls> viewcalls);
    }

    private long attributeCall(Path filePath) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        File file = filePath.toFile();
        file.isDirectory();
        file.lastModified();
        file.length();
        file.canRead();
        file.isHidden();
        file.exists();
        file.isAbsolute();
        file.canWrite();
        file.canExecute();
        file.getAbsolutePath();
        file.getName();

        file.setLastModified(0);
        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);

        stopWatch.stop();
        return stopWatch.getNanoTime();
    }

    private long viewCall(Path filePath) throws IOException {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        BasicFileAttributeView view = Files.getFileAttributeView(filePath, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = view.readAttributes();
        basicFileAttributes.isDirectory();
        basicFileAttributes.lastModifiedTime();
        basicFileAttributes.size();
        basicFileAttributes.creationTime();
        basicFileAttributes.isSymbolicLink();
        basicFileAttributes.isRegularFile();

        view.name();
        basicFileAttributes.lastAccessTime();
        FileTime fileTime = FileTime.fromMillis(0);
        view.setTimes(fileTime,fileTime,fileTime);

        stopWatch.stop();

        return stopWatch.getNanoTime();
    }
}
