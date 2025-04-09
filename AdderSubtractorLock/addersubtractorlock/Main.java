package addersubtractorlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception{
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Lock lockForValue = new ReentrantLock();
        Lock lockForValueString = new ReentrantLock();

        executorService.execute(new Adder(value, lockForValue, lockForValueString));
        executorService.execute(new Subtractor(value, lockForValue, lockForValueString));

        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.MINUTES);

        System.out.println(value.getValue());

    }
}
