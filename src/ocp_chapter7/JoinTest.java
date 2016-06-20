package ocp_chapter7;

import ocp_chapter7.operations.LongOperation;

public class JoinTest {

    public static void main(String... input) throws InterruptedException {
        LongOperation lo = new LongOperation();
        Thread joinThread = new Thread(lo);

        System.out.println("Before start");

        joinThread.start();

        System.out.println("After start");
        System.out.println("Thread alive: " + joinThread.isAlive());

        joinThread.join();

        System.out.println("Thread alive: " + joinThread.isAlive());
        System.out.println("Joined after calculation is done");

    }
}
