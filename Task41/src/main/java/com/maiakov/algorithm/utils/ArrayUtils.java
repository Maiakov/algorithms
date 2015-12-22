package com.maiakov.algorithm.utils;


public class ArrayUtils {
    public static char[] initResultArray(int numberOfDigits, int inputNumber) {
        if (isNumberNegative(inputNumber)) {
            char[] result = new char[numberOfDigits + 1];
            result[0] = '-';
            return result;
        }
        return new char[numberOfDigits];
    }

    public static int getNumberOfDigits(int inputNumber) {
        inputNumber = convertToPositive(inputNumber);
        int count = 0;
        while (inputNumber > 0) {
            count++;
            inputNumber = (inputNumber / 10);
        }
        return count;
    }

    public static int convertToPositive(int value) {
        return isNumberNegative(value) ? -1 * value : value;
    }

    public static int getStartIndex(int numberOfDigits, int inputNumber) {
        return isNumberNegative(inputNumber) ? numberOfDigits : numberOfDigits - 1;
    }

    private static boolean isNumberNegative(int number) {
        return number < 0 ? true : false;
    }
}
