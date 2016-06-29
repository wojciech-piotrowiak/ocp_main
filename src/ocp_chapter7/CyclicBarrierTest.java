package ocp_chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierTest {
    public static void main(String... input) {

        final int threads = 3;
        CyclicBarrier cb = new CyclicBarrier(threads);
        final ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for (int c = 0; c < threads; c++) {
            executorService.submit(() -> {
                try {
                    System.out.println("Started and waiting to break a barrier");
                    cb.await();
                    System.out.println("Wait Done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
