package org.example.Algos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfMediansTest {

    MedianOfMedians medianOfMedians = new MedianOfMedians();

    int[] arr = Utility.randomArray(11);
    //size 11
    @Test
    void findMedianTestElevenElementsArray() {
        int median = medianOfMedians.findMedian(arr, 0, arr.length - 1, arr.length / 2);
    }


    //size 100
    int[] arr2 = Utility.randomArray(100);
    @Test
    void findMedianTestHundredElementsArray()
    {
        int median = medianOfMedians.findMedian(arr2, 0 , arr2.length - 1 , arr2.length / 2);
    }


    //size 1001
    int[] arr3 = Utility.randomArray(1001);

    @Test
    void findMedianTestThousandElementsArray()
    {
        int median = medianOfMedians.findMedian(arr3, 0 , arr3.length - 1, arr3.length / 2);
    }

    //size 10000
    int[] arr4 = Utility.randomArray(10000);

    @Test
    void findMedianTestTenThousandElementsArray()
    {
        int median = medianOfMedians.findMedian(arr4, 0 , arr4.length - 1 , arr4.length / 2);
    }

    //size 50001
    int[] arr5 = Utility.randomArray(50001);
    @Test
    void findMedianTestFiftyThousandElementsArray()
    {

        int median = medianOfMedians.findMedian(arr5, 0 , arr5.length - 1 , arr5.length / 2);
    }

    int[] arr6 = Utility.randomArray(100000);
    //size 100000
    @Test
    void findMedianTestHundredThousandElementsArray()
    {
        int median = medianOfMedians.findMedian(arr6, 0 , arr6.length - 1 , arr6.length / 2);
    }

    //size 200001
    int[] arr7 = Utility.randomArray(200001);

    @Test
    void findMedianTestTwoHundredThousandElementsArray()
    {
        int median = medianOfMedians.findMedian(arr7, 0 , arr7.length - 1, arr7.length / 2);
    }


    int[] arr8 = Utility.randomArray(500000);

    //size 500000
    @Test
    void findMedianTestFiveHundredThousandElementsArray()
    {
        int median = medianOfMedians.findMedian(arr8, 0 , arr8.length - 1, arr8.length / 2);
    }

    int[] arr9 = Utility.randomArray(1000001);

    //size 1000001
    @Test
    void findMedianTestMillionElementsArray()
    {
        int median = medianOfMedians.findMedian(arr9, 0 , arr9.length - 1, arr9.length / 2);
    }

    //size 20000000
    int[] arr10 = Utility.randomArray(2000000);
    @Test
    void findMedianTestTwoMillionElementsArray()
    {

        int median = medianOfMedians.findMedian(arr10, 0 , arr10.length - 1, arr10.length / 2);
    }

    //size 10000000
    int[] arr11 = Utility.randomArray(10000001);
    @Test
    void findMedianTestTenMillionElementsArray()
    {
        int median = medianOfMedians.findMedian(arr11, 0 , arr11.length - 1, arr11.length / 2);
    }

    //size 20000000
    int[] arr12 = Utility.randomArray(20000000);
    @Test
    void findMedianTestTwentyMillionElementsArray()
    {
        int median = medianOfMedians.findMedian(arr12, 0 , arr12.length - 1, arr12.length / 2);
    }

}


