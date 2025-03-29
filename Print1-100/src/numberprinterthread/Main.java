package src.numberprinterthread;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) {
        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            Thread t = new Thread(new HelloPrint(i));
            t.start();
            // Memory for the new thread will be created and this thread will be pt in the waiting queue by
            // OS, main thread will run this loop as it is.
            list.add(t);
            if(i==40){
                System.out.println("Debug");
            }
        }
    }
}
