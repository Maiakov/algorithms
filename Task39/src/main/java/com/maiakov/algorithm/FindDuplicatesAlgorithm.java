package com.maiakov.algorithm;

public class FindDuplicatesAlgorithm {
    private static final int DELETED_ELEMENT = 0;


    public int[] findDuplicates(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        int length = inputArray.length;

        if (length == 1) {
            return inputArray;
        }

        for (int i = 0; i < length; i++) {
            int pointer = inputArray[i] - 1;
            if (pointer < 0) {
                pointer = changeSign(pointer);
            }
            if (inputArray[pointer] > 0) {
                inputArray[pointer] = changeSign(inputArray[pointer]);
            } else {
                deleteElement(inputArray, pointer);
            }
        }
        return prepareArrayOfDuplicates(inputArray);
    }
    private int changeSign(int value) {
        return -1 * value;
    }

    private void deleteElement(int[] inputArray, int pointer) {
        inputArray[pointer] = DELETED_ELEMENT;
    }

    private int[] prepareArrayOfDuplicates(int[] inputArray) {
        int duplicatesCount = getCountOfDuplicates(inputArray);
        int[] arrayOfDuplicates = new int[duplicatesCount];
        if (duplicatesCount == 0) {
            return arrayOfDuplicates;
        }
        int iteratorForDuplicatesArray = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                arrayOfDuplicates[iteratorForDuplicatesArray] = i + 1;
                iteratorForDuplicatesArray++;

            }
        }
        return arrayOfDuplicates;
    }

    private int getCountOfDuplicates(int[] inputArray) {
        int duplicatesCount = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == DELETED_ELEMENT) {
                duplicatesCount++;
            }
        }
        return duplicatesCount;
    }


}
