package tools;


public class Helper {

    public static String getResource(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResource(path).getFile();
    }
}
