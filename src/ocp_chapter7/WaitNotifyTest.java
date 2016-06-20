package ocp_chapter7;

public class WaitNotifyTest {
    public static void main(String... input) throws InterruptedException {
        NotifyThread notifyThread = new NotifyThread();

        System.out.println("Before start");

        notifyThread.start();

        System.out.println("After start");
        System.out.println("Thread alive: " + notifyThread.isAlive());
        System.out.println("Thread counter: " + notifyThread.counter);

        synchronized (notifyThread) {
            notifyThread.wait();
        }

        System.out.println("Thread alive: " + notifyThread.isAlive());
        System.out.println("Thread counter: " + notifyThread.counter);
        System.out.println("After wait()");

    }
}

class NotifyThread extends Thread {
    int counter = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (long a = 0; a < 1_000_000_000; a++) {
                counter++;
            }
            notify();
        }
    }
}
