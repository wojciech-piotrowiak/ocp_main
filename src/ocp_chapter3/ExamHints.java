package ocp_chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.T;

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
