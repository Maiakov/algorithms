package com.maiakov.algorithm;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class RemoveDuplicatesAlgorithm {

    public static int[] removeDuplicates(int[] arrayWithDuplicates) {
        validate(arrayWithDuplicates);
        int length = arrayWithDuplicates.length;
        if (length < 2) {
            return arrayWithDuplicates;
        }
        int uniqueElementsAmount = getUniqueNumbersAmount(arrayWithDuplicates);
        int[] arrayWithoutDuplicates = new int[uniqueElementsAmount];
        arrayWithoutDuplicates[0] = arrayWithDuplicates[0];

        if (uniqueElementsAmount == 1) {
            return arrayWithoutDuplicates;
        }
        int pointer = 0;
        for (int i = 1; i < length; i++) {
            if (arrayWithDuplicates[i] != arrayWithoutDuplicates[pointer]) {
                arrayWithoutDuplicates[++pointer] = arrayWithDuplicates[i];
            }
        }
        return arrayWithoutDuplicates;
    }

    private static void validate(int[] arrayWithDuplicates) {
        if (arrayWithDuplicates == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        int[] sortedArray = Arrays.copyOf(arrayWithDuplicates, arrayWithDuplicates.length);
        Arrays.sort(sortedArray);
        if (Arrays.equals(sortedArray, arrayWithDuplicates)) {
            return;
        }
        ArrayUtils.reverse(sortedArray);
        if (Arrays.equals(sortedArray, arrayWithDuplicates)) {
            return;
        }
        throw new IllegalArgumentException("Input array should be sorted");


    }

    private static int getUniqueNumbersAmount(int[] arrayWithDuplicates) {
        int uniqueElementsCounter = 1;
        for (int i = 0; i < arrayWithDuplicates.length - 1; i++) {
            if (arrayWithDuplicates[i] != arrayWithDuplicates[i + 1]) {
                uniqueElementsCounter++;
            }
        }
        return uniqueElementsCounter;
    }
}
