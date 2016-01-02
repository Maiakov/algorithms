package com.maiakov.algorithm;

import java.util.Arrays;

public class IterativePermutationsAlgorithm extends BasePermutationsAlgorithm {

    @Override
    public void printAllPermutations(String[][] twoDimensionalArray) {
        String[] oneDimensionalArray = convertToOneDimensionalArray(twoDimensionalArray);
        Arrays.sort(oneDimensionalArray);

        print(oneDimensionalArray);

        boolean hasNext = true;

        while (hasNext) {
            hasNext = false;
            for (int tail = oneDimensionalArray.length - 1; tail > 0; tail--) {
                if (stillIncreasing(oneDimensionalArray, tail)) {

                    int rightIndex = oneDimensionalArray.length - 1;

                    while (oneDimensionalArray[tail - 1].compareTo(oneDimensionalArray[rightIndex]) >= 0) {
                        rightIndex--;
                    }

                    swap(tail - 1, rightIndex, oneDimensionalArray);
                    reverseTail(oneDimensionalArray, tail);
                    hasNext = true;
                    break;
                }
            }
            print(oneDimensionalArray);
        }
    }

    private boolean stillIncreasing(String[] oneDimensionalArray, int tail) {
        return oneDimensionalArray[tail - 1].compareTo(oneDimensionalArray[tail]) < 0;
    }

    private void print(String[] oneDimensionalArray) {
        System.out.println(Arrays.toString(oneDimensionalArray));
    }

    private void reverseTail(String[] oneDimensionalArray, int tail) {
        for (int i = tail, j = oneDimensionalArray.length - 1; i < j; i++, j--) {
            swap(i, j, oneDimensionalArray);
        }
    }
}
