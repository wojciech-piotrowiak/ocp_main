package ocp_chapter7.operations;

import java.util.concurrent.Callable;

public class HelloOperation implements Runnable, Callable {
    @Override
    public void run() {
        //without long operation it's more likely for runnable to be processed by the same thread
        new LongOperation().run();
        System.out.println("Current thread number: " + Thread.activeCount());
        System.out.println("My name: " + Thread.currentThread().getName());
        System.out.println("End of hello operation: " + System.nanoTime());
    }

    @Override
    public Object call() throws Exception {
        run();
        return null;
    }
}
