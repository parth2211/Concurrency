package src.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        MergeSort mergeSort = new MergeSort();
        List<Integer> sortedList = mergeSort.mergeSort(list, 0, list.size() -1);

        System.out.println("Sorted List");
        for (Integer integer : sortedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
