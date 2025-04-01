package src.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

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
        if(startIndex >= endIndex) return list;
        int mid = (startIndex + endIndex) / 2;
        mergeSort(list, startIndex, mid);
        mergeSort(list, mid + 1, endIndex);
        return merge(list, startIndex, endIndex, mid);
    }
}
