package com.maiakov.algorithm;

import java.util.Arrays;

abstract public class BasePermutationsAlgorithm {

    public  abstract void printAllPermutations(String[][] twoDimensionalArray);

    protected static String[] convertToOneDimensionalArray(String[][] twoDimensionalArray) {
        String[] oneDimensionalArray = new String[twoDimensionalArray.length * twoDimensionalArray[0].length];
        int index = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                oneDimensionalArray[index++] = twoDimensionalArray[i][j];
            }

        }
        return oneDimensionalArray;
    }


    protected static void swap(int firstIndex, int secondIndex, String[] inputArray) {
        String temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

}
