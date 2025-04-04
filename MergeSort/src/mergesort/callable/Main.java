package src.mergesort.callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(1, 6, 9, 3, 6);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> futureSortedList = executorService.submit(new Sorter(list));

        try {
            List<Integer> sortedList = futureSortedList.get();

            for(Integer integer : sortedList) {
                System.out.print(integer + " ");
            }
        } catch (Exception e) {
            System.out.println(" Exception: " + e.getMessage());
        }
    }
}
