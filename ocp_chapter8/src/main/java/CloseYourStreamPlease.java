import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CloseYourStreamPlease {

    public static void main(String... args)
    {
        for(int i=0;i<8000;i++) {
            //unclosedUsage();
            rightUsage();
        }
    }

    private static void unclosedUsage()
    {
    //may happen: java.io.FileNotFoundException: smalltextfile.txt (Too many open files in system)
    // or memory resource problems

        try
        {
            FileInputStream f = new FileInputStream("smalltextfile.txt");
            BufferedInputStream br=new BufferedInputStream(f);
            FileOutputStream outputStream=new FileOutputStream("copyofsmalltextfile.txt");
            BufferedOutputStream out=new BufferedOutputStream(outputStream);

            int length;
            byte[] buffer=new byte[1024];
            while ((length = br.read(buffer)) >0)
            {
                out.write(buffer,0,length);
                out.flush();
            }
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
    private static void rightUsage()
    {
        try(FileInputStream f = new FileInputStream("smalltextfile.txt");
            BufferedInputStream br=new BufferedInputStream(f);
            FileOutputStream outputStream=new FileOutputStream("copyofsmalltextfile.txt");
            BufferedOutputStream out=new BufferedOutputStream(outputStream))
        {
            int length;
            byte[] buffer=new byte[1024];
            while ((length = br.read(buffer)) >0)
            {
                out.write(buffer,0,length);
                out.flush();
            }
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
