package ocp_chapter7;

import ocp_chapter7.operations.HelloOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolTest {
    public static void main(String... blablabla) throws ExecutionException, InterruptedException {
        System.out.print(String.format("%s[%s]", getNull(), getNull()));
        //threadPoolIncrementalTest();
        //threadPoolInvokeAllTest();
    }

    private static void threadPoolIncrementalTest() {
        System.out.println("ThreadPool incremental example");
        System.out.println("Start thread number: " + Thread.activeCount());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Before submit thread number: " + Thread.activeCount());
        System.out.println("Start time: " + System.nanoTime());
        for (int a = 0; a < 50; a++) {
            executorService.submit((Callable) new HelloOperation());
        }
        executorService.shutdown();
    }

    private static void threadPoolInvokeAllTest() throws InterruptedException {
        System.out.println("--------------------------------------------");
        System.out.println("ThreadPool invokeAll example");
        System.out.println("Start thread number: " + Thread.activeCount());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("Before submit thread number: " + Thread.activeCount());
        System.out.println("Start time: " + System.nanoTime());
        Collection<Callable<Object>> tasks = new ArrayList();
        for (int a = 0; a < 50; a++) {
            tasks.add(new HelloOperation());
        }
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    public static Object getNull() {
        return null;
    }
}
