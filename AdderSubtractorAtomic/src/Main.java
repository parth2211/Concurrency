import addersubtractorlock.Adder;
import addersubtractorlock.Subtractor;
import addersubtractorlock.Value;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception{
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value));
        executorService.execute(new Subtractor(value));

        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.MINUTES);

        System.out.println(value.getValue());

    }
}
