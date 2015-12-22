package com.maiakov.algorithm;


public class QuickSortAlgorithm {
    public static int[] array;

    public static int[] sort(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array can`t be null");
        }
        if (inputArray.length < 2) {
            return inputArray;
        }
        array = inputArray;
        quickSort(0, inputArray.length - 1);
        return array;
    }

    private static void quickSort(int startIndex, int endIndex) {
        int pivot = array[startIndex + (endIndex - startIndex) / 2];
        int i = startIndex;
        int j = endIndex;

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (startIndex < j) {
            quickSort(startIndex, j);
        }
        if (i < endIndex) {
            quickSort(i, endIndex);
        }
    }

    private static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
