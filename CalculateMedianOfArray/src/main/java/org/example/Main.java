package org.example;

import org.example.Algos.MedianOfMedians;
import org.example.Algos.NaiveMethod;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 9 ,4, 2, 10, 7, 13};
        MedianOfMedians median = new MedianOfMedians();
        int themedian = median.findMedian(arr, 0, arr.length - 1, arr.length / 2) ;
        System.out.println(themedian);
    }
}