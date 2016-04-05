import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class CloseYourStreamPlease {

    @Test
    public void rightTest()
    {
        for(int i=0;i<8000;i++) {
            rightUsage();
        }
    }

    @Test(expected=FileNotFoundException.class)
    public void unclosedTest() throws FileNotFoundException {
        for(int i=0;i<8000;i++) {
                FileInputStream f = new FileInputStream(getSmallfileUrl().getFile());
                BufferedInputStream br=new BufferedInputStream(f);
                FileOutputStream outputStream=new FileOutputStream("copyofsmalltextfile.txt");
                BufferedOutputStream out=new BufferedOutputStream(outputStream);

                int length;
                byte[] buffer=new byte[1024];
            try {
                while ((length = br.read(buffer)) >0)
                {
                    out.write(buffer,0,length);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void unclosedUsage() throws FileNotFoundException {
    //may happen: java.io.FileNotFoundException: smalltextfile.txt (Too many open files in system)
    // or memory resource problems



    }
    private void rightUsage()
    {
        try(FileInputStream f = new FileInputStream(getSmallfileUrl().getFile());
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

    private URL getSmallfileUrl() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("smalltextfile.txt");
    }
}
