package ocp_chapter7.operations;

public class LongOperation implements Runnable {
    @Override
    public void run() {
        int counter = 0;
        for (long a = 0; a < 1_000_000_000; a++) {
            counter += a;
        }
    }

}
