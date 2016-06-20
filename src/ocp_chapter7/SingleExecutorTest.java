package ocp_chapter7;


import ocp_chapter7.operations.LongOperation;

import java.util.concurrent.*;

public class SingleExecutorTest {

    public static void main(String... blablabla) throws ExecutionException, InterruptedException {
        runnableExample();
        callableExample();
        cancelExample();
    }

    private static void runnableExample() throws InterruptedException, ExecutionException {
        System.out.println("Runnable example");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Before submit");
        final Future<?> submit = executorService.submit(new LongOperation());
        System.out.println("After submit+before get");
        System.out.println("Is done? : " + submit.isDone());
        //Runnable returns void so get() will always return null
        System.out.println("After get: " + submit.get());
        System.out.println("Is done? : " + submit.isDone());
        System.out.println("---------------------------------");
    }


    private static void callableExample() throws InterruptedException, ExecutionException {
        System.out.println("Callable example");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Before submit");
        final Future<String> submit = executorService.submit(new CallMeMaybe());
        System.out.println("After submit+before get");
        System.out.println("Is done? : " + submit.isDone());
        System.out.println("After get: " + submit.get());
        System.out.println("Is done? : " + submit.isDone());
        System.out.println("---------------------------------");
    }

    private static void cancelExample() throws InterruptedException, ExecutionException {
        System.out.println("Cancel example");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Before submit");
        final Future<String> submit = executorService.submit(new CallMeMaybe());
        System.out.println("After submit+before cancel");
        submit.cancel(true);
        System.out.println("Is cancelled? : " + submit.isCancelled());
        //will throw CancellationException!
        //System.out.println("After get: " + submit.get());
    }
}

class CallMeMaybe implements Callable<String> {
    @Override
    public String call() throws Exception {
        new LongOperation().run();
        return "CallMeMaybe";
    }
}