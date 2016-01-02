package com.maiakov.algorithm;

import java.util.Arrays;

public class RecursivelyPermutationsAlgorithm extends BasePermutationsAlgorithm {

    @Override
    public void printAllPermutations(String[][] twoDimensionalArray) {
        String[] oneDimensionalArray = convertToOneDimensionalArray(twoDimensionalArray);
        permutation(0, oneDimensionalArray);
    }

    private static void permutation(int leftIndex, String[] inputArray) {
        for (int i = leftIndex; i < inputArray.length; i++) {
            swap(i, leftIndex, inputArray);
            permutation(leftIndex + 1, inputArray);
            swap(leftIndex, i, inputArray);
        }
        if (leftIndex == inputArray.length - 1) {
            System.out.println(Arrays.toString(inputArray));
            return;
        }
    }
}
