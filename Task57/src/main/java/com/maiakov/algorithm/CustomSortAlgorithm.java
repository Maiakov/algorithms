package com.maiakov.algorithm;

public class CustomSortAlgorithm {
    public static int[] sort(int[] array, int bound) {
        validate(array, bound);
        int[] result = new int[bound];
        int[] numbersOccurrences = countNumbersOccurrences(array, bound);
        int index = 0;
        for (int i = 0; i < bound; i++) {
            if (numbersOccurrences[i] == 0) {
                continue;
            }
            for (int j = 0; j < numbersOccurrences[i] && index < bound; j++) {
                result[index++] = i + 1;
            }
        }
        return result;
    }

    private static int[] countNumbersOccurrences(int[] array, int bound) {
        int[] temp = new int[bound];
        for (int i = 0; i < array.length; i++) {
            temp[array[i] - 1]++;
        }
        return temp;
    }

    private static void validate(int[] array, int bound) {
        if (array == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        if (array.length < bound) {
            throw new IllegalArgumentException("Bound out of array length");
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        if (max != bound) {
            throw new IllegalArgumentException("Incorrect bound");
        }
    }
}
