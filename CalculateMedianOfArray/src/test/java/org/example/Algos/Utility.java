package org.example.Algos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Random;

public class Utility {

    private static final int MIN = 1;
    private static final int MAX = 1000000000;

    static int getRandom()
    {
        Random random = new Random();
        int randomNumber = random.ints(MIN, MAX)
                .findFirst()
                .getAsInt();
        return randomNumber;
    }

    static int[] randomArray(int size)
    {
        int arr[] = new int[size];
        for(int i = 0 ; i < arr.length; i ++)
        {
            arr[i] = getRandom();
        }
        return arr;
    }
}
