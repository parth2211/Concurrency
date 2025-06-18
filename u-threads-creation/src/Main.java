import threadcreator.ThreadCreatorClass;
import threadcreator.ThreadCreatorRunnable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total expected time for both threads to run is : 1000 * 10 MILLIS w/o multithreading");

        System.out.println("But .................");

        long startTime = System.currentTimeMillis();

        Thread threadCreatedClass = new ThreadCreatorClass();
        Thread threadCreatorRunnable = new Thread(new ThreadCreatorRunnable());

        threadCreatedClass.start();
        threadCreatorRunnable.start();

        try {
            threadCreatedClass.join();
            threadCreatorRunnable.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Overall program execution time: " + duration + " millis");
    }
}