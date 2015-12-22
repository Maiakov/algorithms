package com.maiakov.algorithm;

public class RandomPermutationAlgorithm {

    public static int[] randomPermutation(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        if (array.length < 2) {
            return array;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int newPosition = getNewPosition(length);
            swap(array, i, newPosition);
        }
        return array;
    }

    private static int getNewPosition(int length) {
        return Random.getRandomNumber(length) - 1;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
