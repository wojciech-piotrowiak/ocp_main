import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.fail;

public class CloseYourStreamPlease {

    @Test
    public void rightTest()
    {
        for(int i=0;i<8000;i++) {
            rightUsage();
        }
    }

    @Test
    public void unclosedTest()  {
        //may happen: java.io.FileNotFoundException: smalltextfile.txt (Too many open files in system)
        // or memory resource problems

        for(int i=0;i<8000;i++) {
            try {
                FileInputStream f = new FileInputStream(getSmallfileUrl().getFile());
                BufferedInputStream br=new BufferedInputStream(f);
            } catch (FileNotFoundException e) {
                fail("Too many open files in system");
            }

        }
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
        return getClass().getResource("smalltextfile.txt");
    }
}
