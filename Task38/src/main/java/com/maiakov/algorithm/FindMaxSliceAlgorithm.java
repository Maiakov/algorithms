package com.maiakov.algorithm;

import java.util.Arrays;


public class FindMaxSliceAlgorithm {

    private int endIndexOfMaxSlice;
    private int startIndexOfMaxSlice;
    private int startIndexOfCurrentSlice;

    public int[] findMaxSlice(int[] inputArray) {

        inputArray = validate(inputArray);

        int length = inputArray.length;
        if (length == 1) {
            return inputArray;
        }

        int lastBestResult = inputArray[0];
        int maxSlice = inputArray[0];
        startIndexOfMaxSlice = 0;
        endIndexOfMaxSlice = 0;
        startIndexOfCurrentSlice = 0;

        for (int i = 1; i < length; i++) {
            lastBestResult += inputArray[i];

            if (inputArray[i] > lastBestResult) {
                startIndexOfCurrentSlice = i;
                lastBestResult = inputArray[i];
            }
            if (maxSlice < lastBestResult) {
                endIndexOfMaxSlice = i;
                startIndexOfMaxSlice = startIndexOfCurrentSlice;
                maxSlice = lastBestResult;
            }
        }
        return getFinalSlice(inputArray);
    }

    private int[] getFinalSlice(int[] inputArray) {
        return Arrays.copyOfRange(inputArray, startIndexOfMaxSlice, endIndexOfMaxSlice + 1);
    }

    private int[] validate(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array can`t be null");
        }
        if (inputArray.length == 0) {
            throw new IllegalArgumentException("Input array can`t be empty");
        }
        return inputArray;
    }
}

