package org.example;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private class Point{
        long x ;
        long y ;
        boolean isLeft = false;
    }

    private long distance(long[] point1, long[] point2)
    {
        long xDistance = Math.abs(point1[0] - point2[0]);
        long yDistance = Math.abs(point1[1] - point2[1]) ;
        return Math.max(xDistance, yDistance);
    }

    private long findMaxSideLenght(Point[] xSortedArray, Point[] ySortedArray)
    {
        int numberOfPoints = xSortedArray.length ;
        //base cases
        //if number of points 2 , 3
        if(numberOfPoints == 2)
        {
            long[] point1 = {xSortedArray[0].x, xSortedArray[0].y};
            long[] point2 = {xSortedArray[1].x, xSortedArray[1].y};
            return distance(point1, point2);
        }
        if(numberOfPoints == 3)
        {
            long[] point1 = {xSortedArray[0].x, xSortedArray[0].y};
            long[] point2 = {xSortedArray[1].x, xSortedArray[1].y};
            long[] point3 = {xSortedArray[2].x, xSortedArray[2].y};
            long distance1 = distance(point1, point2);
            long distance2 = distance(point2, point3);
            long distance3 = distance(point1, point3);
            return Math.min(distance1, Math.min(distance2, distance3));
        }

        int midPoint = numberOfPoints / 2 ;

        // split the arrays and mark portions
        Point[] xSortedArrayleftPortion = Arrays.copyOfRange(xSortedArray, 0, midPoint);
        for(int i = 0 ; i < midPoint ; i ++) { xSortedArray[i].isLeft = true ;}
        Point[] xSortedArrayrightPortion = Arrays.copyOfRange(xSortedArray, midPoint , numberOfPoints);
        for(int i = midPoint ; i < numberOfPoints ; i ++) { xSortedArray[i].isLeft = false ; }

        // start splitting y sorted array
        Point[] ySortedArrayLeftPortion = new Point[midPoint];
        Point[] ySortedArrayRightPortion = new Point[numberOfPoints - midPoint];

        int leftIndex = 0 ;
        int rightIndex = 0 ;

        for(int i = 0 ; i < numberOfPoints ; i ++)
        {
            if(ySortedArray[i].isLeft)
            {
                ySortedArrayLeftPortion[leftIndex] = ySortedArray[i];
                leftIndex ++ ;
            }
            else
            {
                ySortedArrayRightPortion[rightIndex] = ySortedArray[i];
                rightIndex ++ ;
            }
        }

        long minDistanceLeft = findMaxSideLenght(xSortedArrayleftPortion, ySortedArrayLeftPortion);
        long minDistanceRight = findMaxSideLenght(xSortedArrayrightPortion, ySortedArrayRightPortion);

        //get the maximum side length from each portion
        long maxSideLength = Math.min(minDistanceLeft, minDistanceRight);

        //assign the strip of 2 * delta
        Point[] strip = new Point[numberOfPoints];

        int stripIndex = 0 ;
        for(int i = 0 ; i < numberOfPoints ; i ++)
        {
            if(Math.abs(ySortedArray[i].x - ySortedArray[midPoint].x) < maxSideLength && (i != midPoint))
            {
                strip[stripIndex] = new Point();
                strip[stripIndex].y = ySortedArray[i].y;
                strip[stripIndex].x = ySortedArray[i].x;
                stripIndex ++ ;
            }
        }

        for(int i = 0 ; i < stripIndex ; i ++)
        {
            for(int j = 1 ; j <= 7 ; j ++)
            {
                if(i + j < stripIndex)
                {
                    long[] point1 = {strip[i].x, strip[i].y};
                    long[] point2 = {strip[i + j].x, strip[i + j].y};
                    long distance = distance(point1, point2);
                    if(distance < maxSideLength)
                    {
                        maxSideLength = distance;
                    }
                }
            }
        }
        return maxSideLength;
    }
    public long solve(String inputFile)
    {
        try {
            File input_file = new File(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input_file));
            int pointsCount = Integer.parseInt(bufferedReader.readLine());
            Point[] coordinates = new Point[pointsCount];
            String[] brInput = new String[2];
            for(int c = 0 ; c < pointsCount ; c ++)
            {
                brInput = bufferedReader.readLine().split(" ");
                coordinates[c] = new Point();
                coordinates[c].x = Long.parseLong(brInput[0]);
                coordinates[c].y = Long.parseLong(brInput[1]);
            }

            Point[] xSortedArray = new Point[pointsCount];
            Point[] ySortedArray = new Point[pointsCount];

            //sort the array by x
            Arrays.sort(coordinates, (point1, point2) -> Long.compare(point1.x, point2.x));
            for(int i = 0 ; i < pointsCount ; i ++)  xSortedArray[i] = coordinates[i];

            //sort the array by y
            Arrays.sort(coordinates, (point1, point2) -> Long.compare(point1.y, point2.y));
            for(int i = 0 ; i < pointsCount ; i ++)  ySortedArray[i] = coordinates[i];

            return findMaxSideLenght(xSortedArray, ySortedArray);

        }
        catch (IOException ioException)
        {
            return 0 ;
        }
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        System.out.println(main.solve("test.txt"));
    }
}
