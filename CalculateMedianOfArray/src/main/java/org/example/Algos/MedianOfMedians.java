package org.example.Algos;

import java.util.ArrayList;

public class MedianOfMedians implements IMedianAlgorithms {
    private static int[] sort(int[] arr, int[] group) {
        int i = 0, j = 0, tmp;
        //bubble sort with while loop
        while (i < group.length - 1) {
            for (j = 0; j < group.length - i - 1; j++) {
                if (arr[group[j]] > arr[group[j + 1]]) {
                    tmp = arr[group[j]];
                    arr[group[j]] = arr[group[j + 1]];
                    arr[group[j + 1]] = tmp;
                }
            }
            i++;
        }
        return arr;
    }

    private int partitionArray(int[] array, int p, int r){
        int com = array[r];
        int i = p-1;

        for (int j = p; j<r;j++){
            if(array[j] <= com){
                i++;
                swap(array, i, j);
            }
        }

        swap(array,i+1, r);
        return i+1;
    }

    private int partitionAround(int[] array, int p, int r, int x){
        for (int i = p; i <= r; i++){
            if(array[i] == x){
                swap(array, i, r);
                break;
            }
        }

        return partitionArray(array, p, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]= tmp;
    }

    public int findMedian(int[] arr, int start, int end, int toFind) {

        while ((end - start + 1) % 5 != 0) {
            for (int j = start + 1; j <= end; j++) {
                if (arr[start] > arr[j]) {
                    swap(arr, start, j);
                }
            }
            if (toFind == 1) {
                return arr[start];
            }
            start++;
            toFind--;
        }
        int numberOfGroups = (end - start + 1) / 5;
        int[] groupElements = {0, 0, 0, 0, 0};
        for (int c = start; c < start + numberOfGroups - 1 ; c++) {
            groupElements[0] = c;
            groupElements[1] = c + numberOfGroups;
            groupElements[2] = c + 2 * numberOfGroups;
            groupElements[3] = c + 3 * numberOfGroups;
            groupElements[4] = c + 4 * numberOfGroups;
            arr = sort(arr, groupElements);
        }

        int pivot = findMedian(arr, start + 2 * numberOfGroups, start + 3 * numberOfGroups - 1, (numberOfGroups+1) / 2);
        int pivotIndex = partitionAround(arr, start, end, pivot);

        int toFindRelative = pivotIndex - start + 1 ;
        if (toFind == toFindRelative) {
            return arr[pivotIndex];
        } else if (toFind < toFindRelative) {
            return findMedian(arr, start, pivotIndex - 1, toFind);
        } else {
            return findMedian(arr, pivotIndex + 1, end, toFind - toFindRelative);
        }
    }
}
