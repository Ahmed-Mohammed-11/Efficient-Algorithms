package org.example.Algos;
import org.junit.jupiter.api.Test;

class NaiveMethodTest {

    NaiveMethod naiveMethod = new NaiveMethod();

    int[] arr = Utility.randomArray(11);
    //size 11
    @Test
    void findMedianTestElevenElementsArray() {
        int median = naiveMethod.findMedian(arr);
    }


    //size 100
    int[] arr2 = Utility.randomArray(100);
    @Test
    void findMedianTestHundredElementsArray()
    {
        int median = naiveMethod.findMedian(arr2);
    }


    //size 1001
    int[] arr3 = Utility.randomArray(1001);

    @Test
    void findMedianTestThousandElementsArray()
    {
        int median = naiveMethod.findMedian(arr3);
    }

    //size 10000
    int[] arr4 = Utility.randomArray(10000);

    @Test
    void findMedianTestTenThousandElementsArray()
    {
        int median = naiveMethod.findMedian(arr4);
    }

    //size 50001
    int[] arr5 = Utility.randomArray(50001);
    @Test
    void findMedianTestFiftyThousandElementsArray()
    {

        int median = naiveMethod.findMedian(arr5);
    }

    int[] arr6 = Utility.randomArray(100000);
    //size 100000
    @Test
    void findMedianTestHundredThousandElementsArray()
    {
        int median = naiveMethod.findMedian(arr6);
    }

    //size 200001
    int[] arr7 = Utility.randomArray(200001);

    @Test
    void findMedianTestTwoHundredThousandElementsArray()
    {
        int median = naiveMethod.findMedian(arr7);
    }


    int[] arr8 = Utility.randomArray(500000);

    //size 500000
    @Test
    void findMedianTestFiveHundredThousandElementsArray()
    {
        int median = naiveMethod.findMedian(arr8);
    }

    int[] arr9 = Utility.randomArray(1000001);

    //size 1000001
    @Test
    void findMedianTestMillionElementsArray()
    {
        int median = naiveMethod.findMedian(arr9);
    }

    //size 20000000
    int[] arr10 = Utility.randomArray(2000000);
    @Test
    void findMedianTestTwoMillionElementsArray()
    {

        int median = naiveMethod.findMedian(arr10);
    }

    //size 10000000
    int[] arr11 = Utility.randomArray(10000001);
    @Test
    void findMedianTestTenMillionElementsArray()
    {
        int median = naiveMethod.findMedian(arr11);
    }

    //size 20000000
    int[] arr12 = Utility.randomArray(20000000);
    @Test
    void findMedianTestTwentyMillionElementsArray()
    {
        int median = naiveMethod.findMedian(arr12);
    }

}


