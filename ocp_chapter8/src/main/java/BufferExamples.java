import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BufferExamples
{

	public static void main(String... args)
	{
		nonBufferExample();
		bufferStreamExample();
		bufferExample();
	}

	private static void nonBufferExample()
	{
		try (FileInputStream f = new FileInputStream("resources/bigtextfile.txt"))
		{
            StopWatch stopWatch=new StopWatch();
            stopWatch.start();
			int b;
			while ((b = f.read()) != -1)
			{
			}
            stopWatch.stop();
			System.out.println(stopWatch.getTime() + " ms without buffer");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void bufferExample()
	{
		try (FileInputStream f = new FileInputStream("resources/bigtextfile.txt");
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
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void bufferStreamExample()
	{
		try (FileInputStream f = new FileInputStream("resources/bigtextfile.txt");
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
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
