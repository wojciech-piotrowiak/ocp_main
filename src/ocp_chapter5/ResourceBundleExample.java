package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleExample {
    @Test
    public void resourceBundleTest() {
        ResourceBundle germanBundle = ResourceBundle.getBundle("chapter5//test", Locale.GERMAN);
        Assert.assertEquals("German Key", germanBundle.getString("exampleKey"));

        ResourceBundle englishBundle = ResourceBundle.getBundle("chapter5//test", Locale.ENGLISH);
        Assert.assertEquals("English Key", englishBundle.getString("exampleKey"));
    }

    @Test
    public void allKeysFromBundle() {
        ResourceBundle bundle = ResourceBundle.getBundle("chapter5//test", Locale.GERMAN);
        bundle.keySet().stream().forEach(System.out::println);
    }

    @Test(expected = MissingResourceException.class)
    public void notExistingLocale() {
        //getBundle without locale gets bundle for current locale. It works on my machine because i'm not using german or english
        ResourceBundle.getBundle("chapter5//test");
    }

    @Test
    public void getBundleWithoutLocale() {
        //now it's possible because there is a bundle for German
        Locale.setDefault(Locale.GERMAN);
        ResourceBundle bundle = ResourceBundle.getBundle("chapter5//test", Locale.GERMAN);
        bundle.keySet().stream().forEach(System.out::println);
    }
}
