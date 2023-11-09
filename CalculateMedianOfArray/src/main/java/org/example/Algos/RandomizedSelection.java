package org.example.Algos;

class RandomizedSelection implements IMedianAlgorithms {

    private int getRandomInteger(int min, int max) {
        int random = (int) ((Math.random() * (max - min)) + min);
        return random;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int tmp;
        for (int j = start + 1; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        tmp = arr[i];
        arr[i] = arr[start];
        arr[start] = tmp;
        return i;
    }


    private int randomPartition(int[] arr, int start, int end) {
        int pivotIndex = getRandomInteger(start, end - 1);
        int tmp = arr[start];
        arr[start] = arr[pivotIndex];
        arr[pivotIndex] = tmp;
        return partition(arr, start, end);
    }


    @Override
    public int findMedian(int[] arr, int start, int end, int toFind) {
        if (start == end) {
            return arr[start];
        }

        int pivotIndex = randomPartition(arr, start, end);

        if (toFind == pivotIndex) {
            return arr[pivotIndex];
        } else if (toFind < pivotIndex) {
            return findMedian(arr, start, pivotIndex, toFind);
        } else {
            return findMedian(arr, pivotIndex + 1, end, toFind);
        }
    }
}
