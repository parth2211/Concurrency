package src.mergesort.runnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Sort is a divide and conquer algorithm that sorts an array by recursively
 * dividing it into two halves, sorting each half, and then merging the sorted halves.
 * This implementation uses a thread pool to execute the sorting in parallel.
 *
 * Only single thread is used to sort the list since we are using Runnable.
 */
public class MergeSort implements Runnable{

    List<Integer> list;

    MergeSort(List<Integer> list) {
        this.list = list;
    }

    List<Integer> merge(List<Integer> list, int startIndex, int endIndex, int mid) {
        List<Integer> mergeList = new ArrayList<>();
        int leftStartIndex = startIndex, rightStartIndex = mid + 1;

        while(leftStartIndex <= mid && rightStartIndex <= endIndex) {
            if(list.get(leftStartIndex) <= list.get(rightStartIndex)) {
                mergeList.add(list.get(leftStartIndex));
                leftStartIndex++;
            } else {
                mergeList.add(list.get(rightStartIndex));
                rightStartIndex++;
            }
        }

        while(leftStartIndex <= mid) {
            mergeList.add(list.get(leftStartIndex));
            leftStartIndex++;
        }

        while(rightStartIndex <= endIndex) {
            mergeList.add(list.get(rightStartIndex));
            rightStartIndex++;
        }

        for(Integer integer : mergeList) {
            list.set(startIndex, integer);
            startIndex++;
        }

        return list;
    }

    List<Integer> mergeSort(List<Integer> list, int startIndex, int endIndex) {
        System.out.println(Thread.currentThread().getName());
        if(startIndex >= endIndex) return list;
        int mid = (startIndex + endIndex) / 2;
        mergeSort(list, startIndex, mid);
        mergeSort(list, mid + 1, endIndex);
        return merge(list, startIndex, endIndex, mid);
    }

    @Override
    public void run() {
        this.mergeSort(list, 0, list.size() - 1);

        System.out.println("Sorted List");
        for (Integer integer : this.list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
