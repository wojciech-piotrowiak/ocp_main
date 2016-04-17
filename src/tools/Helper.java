package tools;


import java.io.File;
import java.net.URL;

public class Helper {

    public static String getResource(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResource(path).getFile().substring(1);
    }
}
