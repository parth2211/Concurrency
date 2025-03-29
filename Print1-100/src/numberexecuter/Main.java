package src.numberexecuter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String [] args) {

        ExecutorService executorOdd = Executors.newSingleThreadExecutor();
        ExecutorService executorEven = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                executorEven.execute(new HelloPrint(i));
            } else {
                executorOdd.execute(new HelloPrint(i));
            }
        }
    }
}
