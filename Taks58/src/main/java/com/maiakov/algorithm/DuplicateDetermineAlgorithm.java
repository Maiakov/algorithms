package com.maiakov.algorithm;

public class DuplicateDetermineAlgorithm {
    public static boolean isContainsDuplicate(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        if (array.length < 2) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            int pointer = convertToPositive(array[i]) - 1;
            if (array[pointer] > 0) {
                array[pointer] = changeSign(array[pointer]);
            } else {
                return true;
            }
        }
        return false;
    }

    private static int convertToPositive(int value) {
        return value < 0 ? changeSign(value) : value;
    }

    private static int changeSign(int value) {
        return -1 * value;
    }
}
