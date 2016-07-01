package ocp_chapter2;


import org.junit.Assert;
import org.junit.Test;

import java.util.Hashtable;
import java.util.TreeSet;

public class ExamHints {
    @Test(expected = NullPointerException.class)
    public void nullAsHashTableValue() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("", null);
    }

    @Test(expected = NullPointerException.class)
    public void nullAsHashTableKey() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "22");
    }

    @Test(expected = NullPointerException.class)
    public void nullAsTreeSetKey() {
        TreeSet<String> set = new TreeSet<>();
        set.add(null);
    }
}
