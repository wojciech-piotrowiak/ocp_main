package ocp_chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeSet;
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
    public void duplicatedTreeMap() {

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
