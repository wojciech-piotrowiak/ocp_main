import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;


public class BufferExamples
{
    @Test
    public void test() throws IOException {
        Assert.assertTrue(bufferStreamExample()<bufferExample());
        Assert.assertTrue(bufferExample()<nonBufferExample());
    }

	public long nonBufferExample() throws IOException {
		try (FileInputStream f = new FileInputStream(getBigFileUrl().getFile()))
		{
            StopWatch stopWatch=new StopWatch();
            stopWatch.start();
			int b;
			while ((b = f.read()) != -1)
			{
			}
            stopWatch.stop();
			System.out.println(stopWatch.getTime() + " ms without buffer");
            return  stopWatch.getTime();
		}
	}

    public long bufferExample() throws IOException {
		try (FileInputStream f = new FileInputStream(getBigFileUrl().getFile());
				BufferedInputStream br = new BufferedInputStream(f))
		{

            StopWatch stopWatch=new StopWatch();
            stopWatch.start();
			int b;
			while ((b = br.read()) != -1)
			{
			}
            stopWatch.stop();
			System.out.println(stopWatch.getTime() + " ms with buffered stream");
            return  stopWatch.getTime();
		}
	}

	public long bufferStreamExample() throws IOException {
		try (FileInputStream f = new FileInputStream(getBigFileUrl().getFile());
				BufferedInputStream br = new BufferedInputStream(f))
		{

			int b;
            StopWatch stopWatch=new StopWatch();
            stopWatch.start();
			byte[] buffer = new byte[1024];
			while ((br.read(buffer)) > 0)
			{
			}
			stopWatch.stop();
			System.out.println(stopWatch.getTime() + " ms with buffer and buffered stream");
            return  stopWatch.getTime();
		}
	}

    private URL getBigFileUrl() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("bigtextfile.txt");
    }
}
