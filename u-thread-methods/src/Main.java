import threadcreator.ThreadCreatorClass;
import threadcreator.ThreadCreatorRunnable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total expected time for both threads to run is : 1000 * 10 MILLIS w/o multithreading");

        System.out.println("But .................");

        long startTime = System.currentTimeMillis();

        Thread threadCreatedClass = new ThreadCreatorClass();
        Thread threadCreatorRunnable = new Thread(new ThreadCreatorRunnable());

        //threadCreatedClass.start();
        //threadCreatorRunnable.start();

        /**
         * 1. Interrupting a Sleeping Thread
         * Write a program where a thread sleeps for 5 seconds, but another thread interrupts it after 2 seconds. Handle the InterruptedException properly.
         * When an InterruptedException is thrown, the thread's interrupt flag is automatically cleared by the JVM. This means that after the exception is
         * caught, the isInterrupted() method will return false unless the flag is explicitly restored.
         */

        Thread longThread = new Thread(() -> {
            try {
                System.out.println("Interrupted? " + Thread.currentThread().isInterrupted());
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted by shortThread");
                System.out.println("Interrupted? " + Thread.currentThread().isInterrupted() + " & " + Thread.interrupted());
                System.out.println("Restored? " + Thread.currentThread().isInterrupted());
            }
        },"longThread");

        Thread shortThread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                longThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "shortThread");

        longThread.start();
        shortThread.start();
    }
}