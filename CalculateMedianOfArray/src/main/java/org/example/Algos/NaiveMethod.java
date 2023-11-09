package org.example.Algos;

import java.util.Arrays;

public class NaiveMethod {
    public int findMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
