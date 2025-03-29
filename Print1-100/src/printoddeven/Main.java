package src.printoddeven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String [] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++) {
            executor.execute(new HelloPrint(i));
            //  Allocating thread management to executor.
            // We only care about our logic to be ran by threads.
            if(i==40){
                System.out.println("Debug");
            }
        }
        executor.shutdown();
    }
}
