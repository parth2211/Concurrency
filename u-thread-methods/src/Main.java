import threadcreator.ThreadCreatorClass;
import threadcreator.ThreadCreatorRunnable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total expected time for both threads to run is : 1000 * 10 MILLIS w/o multithreading");

        System.out.println("But .................");

        long startTime = System.currentTimeMillis();

        Thread threadCreatedClass = new ThreadCreatorClass();
        Thread threadCreatorRunnable = new Thread(new ThreadCreatorRunnable());

        try {
            threadCreatedClass.start();
        } catch(RuntimeException e) {
            System.out.println("threadCreatedClass.join()");
            e.printStackTrace();
        }

        try {
            threadCreatorRunnable.start();
        } catch(RuntimeException e) {
            System.out.println("threadCreatedClass.start()");
            e.printStackTrace();
        }

        try {
           threadCreatedClass.join();
        } catch (InterruptedException e) {
            System.out.println("threadCreatedClass Thread Interrupted...");
        }

        try {
            threadCreatorRunnable.join();
        } catch (InterruptedException e) {
            System.out.println("threadCreatorRunnable Thread Interrupted...");
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Overall program execution time: " + duration + " millis");
    }
}