package ocp_chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

/**
 * Created by wpiotrowiak on 11.06.16.
 */
public class ExamHints {

    @Test
    public void streamHints() {
        //will not print ABC, because peek is an intermediate function and this stream is never executed
        Stream.of("ABC").peek(System.out::print);
        //Terminated stream example
        Stream.of("Hello World").peek(System.out::print).count();
    }

    @Test
    public void forEachExample() {
        //Stream and lists can be processed with forEach
        Arrays.asList("1", "2").forEach(System.out::println);
        Stream.of("A", "B").forEach(System.out::println);
    }

    @Test
    public void itIsNotNecessaryToHaveTypeDefined() {
        test test = new test();
        test.setT("1");
        Assert.assertEquals("1", test.get());
    }

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

    @Test
    public void duplicatedTreeSet() {
        TreeSet<String> set = new TreeSet<>();
        System.out.println(set.add("a"));
        System.out.println(set.add("a"));
        Assert.assertTrue(set.size() == 1);
    }

    @Test
    public void duplicatedTreeMap() {
        TreeMap<String, String> set = new TreeMap<>();
        set.put("a", "1");
        set.put("a", "A");
        Assert.assertTrue(set.size() == 1);
        Assert.assertEquals("A", set.get("a"));
    }

    @Test
    public void skipCollections() {
        ConcurrentSkipListSet<String> strings = new ConcurrentSkipListSet<>();
        strings.add("a");
        strings.add("d");
        strings.add("z");
        strings.add("y");
        //values are sorted
        System.out.println(strings);

        ConcurrentSkipListMap<String, String> listMap = new ConcurrentSkipListMap<>();
        listMap.put("a", "b1");
        listMap.put("z", "b2");
        listMap.put("1", "b3");
        listMap.put("A", "b4");
        listMap.put("a", "b5");
        listMap.put("ac", "b6");
        //values are sorted
        System.out.println(listMap);
    }


    class test<T> {
        T value;


        public T get() {
            return value;
        }

        public void setT(T t) {
            value = t;
        }
    }
}
