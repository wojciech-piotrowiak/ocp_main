package ocp_chapter4;

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
    }
}
