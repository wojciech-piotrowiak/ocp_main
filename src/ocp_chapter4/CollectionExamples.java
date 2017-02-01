package ocp_chapter4;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionExamples {

    @Test
    public void maps() {
        Map<String, String> hash = new HashMap<>();
        hash.put("1", "21");
        hash.put("5", "22");
        hash.put("6", "23");
        hash.put("4", "24");
        //keys as created
        System.out.println(hash);

        Map<String, String> tree = new TreeMap<>();
        tree.put("6", "21");
        tree.put("1", "22");
        tree.put("5", "23");
        tree.put("4", "24");
        //keys are sorted
        System.out.println(tree);

        Assert.assertEquals("21", tree.get("6"));
        Assert.assertEquals("22", tree.get("1"));


        //replace example

        tree.replace("6", "0");
        //will not work because cuurent val is not 5
        System.out.println(tree.replace("1", "5", "5"));
        //is ok
        System.out.println(tree.replace("1", "22", "5"));

        Assert.assertEquals("0", tree.get("6"));
        Assert.assertEquals("5", tree.get("1"));
    }

    @Test
    public void merge() {
        Map<String, String> hash = new HashMap<>();
        hash.put("1", "21");
        hash.put("5", "22");
        hash.put("6", "23");
        hash.put("4", "24");
        //TODO
    }
}
