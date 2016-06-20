package ocp_chapter7;

public class InterruptedTest {

    public static void main(String... abc) throws InterruptedException {
        Thread firstThread = new Thread(new Run());
        Thread secondThread = new Thread(new Run());

        // state -> NEW
        printStatus(firstThread, secondThread);

        firstThread.start();
        secondThread.start();

        //state runnable
        printStatus(firstThread, secondThread);

        Thread.sleep(1);

        firstThread.interrupt();
        secondThread.interrupt();

        //some of them might be blocked during interruption
        printStatus(firstThread, secondThread);

        Thread.sleep(1);

        //status terminated
        printStatus(firstThread, secondThread);
    }

    private static void printStatus(Thread firstThread, Thread secondThread) {
        System.out.println("Thread: " + firstThread.getName() + " state: " + firstThread.getState());
        System.out.println("Thread: " + secondThread.getName() + " state: " + secondThread.getState());
    }

}

class Run implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        }
    }
}
