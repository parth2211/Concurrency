package src.mergesort.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> list;

    Sorter(List<Integer> list) {
        this.list = list;
    }

    List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> finalList= new ArrayList<>();
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(left.get(i) < right.get(j)) {
                finalList.add(left.get(i));
                i++;
            } else {
                finalList.add(right.get(j));
                j++;
            }
        }

        while(i < left.size()) {
            finalList.add(left.get(i));
            i++;
        }

        while(j < right.size()) {
            finalList.add(right.get(j));
            j++;
        }

        return finalList;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());

        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * This is a non-blocking call, line 29 and 30 will be executed in parallel
         */
        Future<List<Integer>> futureSortedLeft = executorService.submit(new Sorter(left));
        Future<List<Integer>> futureSorterRight = executorService.submit(new Sorter(right));

        /**
         *This is a blocking call (will wait till the Future return)
         */
        List<Integer> sortedLeft = futureSortedLeft.get();
        List<Integer> sortedRight = futureSorterRight.get();

        List<Integer> finalList = merge(sortedLeft, sortedRight);
        return finalList;
    }
}
