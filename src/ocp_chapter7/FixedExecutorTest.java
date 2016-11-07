package ocp_chapter7;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedExecutorTest {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    AtomicInteger inputOut = new AtomicInteger();

    public static void main(String... input) {
        FixedExecutorTest fixedExecutorTest = new FixedExecutorTest();
        long l = System.nanoTime();
        AtomicInteger inputC = new AtomicInteger();

        for (int a = 0; a < 500; a++) {
            inputC.getAndIncrement();
            fixedExecutorTest.schedule("1", "B");
        }
        while (inputC.get() != fixedExecutorTest.inputOut.get()) {
        }
        long l2 = System.nanoTime();
        System.out.println("Time: " + (l2 - l));
    }

//T1:69244849
//T4:39836380

    public void schedule(String cunbr, String ibol) {
        ImmutablePair<String, String> pair = new ImmutablePair<>(cunbr, ibol);
        executorService.submit(new API(pair));
    }

    private class API implements Runnable {
        ImmutablePair pair;

        public API(ImmutablePair<String, String> pair) {
            this.pair = pair;
        }

        @Override
        public void run() {
            for (int c = 0; c < 100000; c++) {
            }
            System.out.println(pair.getLeft() + " " + pair.getRight() + System.currentTimeMillis());
            inputOut.getAndIncrement();
        }
    }
}
