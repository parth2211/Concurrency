package src.mergesort.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSortMain {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for( int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Unsorted List");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        MergeSort mergeSort = new MergeSort(list);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new MergeSort(list));
        executor.shutdown();
    }
}
