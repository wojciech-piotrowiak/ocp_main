package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class PropertiesExamples {
    @Test
    public void fallbackExample() {
        Properties properties = new Properties();
        Assert.assertEquals(null, properties.getProperty("testKey"));
        Assert.assertEquals("fallbackValues", properties.getProperty("testKey", "fallbackValues"));
    }
}
