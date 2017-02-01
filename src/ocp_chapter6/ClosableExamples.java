package ocp_chapter6;

import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

public class ClosableExamples {

    @Test
    public void closable() {
        //Closable interface also could be used, however it throws IOException, not Exception
        try (ClosableExample closableExamples = new ClosableExample("")) {
            throwSth("try exceptions are privileged!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void closableOrdering() {
        try (ClosableExample closableExamples = new ClosableExample("1");
             AutoClosableExample autoClosableExample = new AutoClosableExample("2")) {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void throwSth(String text) {
        throw new IllegalArgumentException(text);
    }


    private class ClosableExample implements Closeable {
        String id;

        public ClosableExample(String id) {
            this.id = id;
        }

        @Override
        public void close() throws IOException {
            System.out.println(id);
            throwSth("try-with-resources exceptions are not privileged!, they are just suppressed");
        }
    }

    private class AutoClosableExample implements AutoCloseable {
        String id;

        public AutoClosableExample(String id) {
            this.id = id;
        }

        @Override
        public void close() throws Exception {
            System.out.println(id);
            throwSth("try-with-resources exceptions are not privileged!, they are just suppressed");
        }
    }
}
