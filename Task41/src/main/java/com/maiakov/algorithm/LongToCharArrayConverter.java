package com.maiakov.algorithm;

import com.maiakov.algorithm.utils.ArrayUtils;

public class LongToCharArrayConverter {
    private static final int DIGITS_START_INDEX = 48;
    private static final char ZERO_CHARACTER = '0';

    private char[] result;

    public char[] convertLongNumberToCharArray(int inputNumber) {
        if (inputNumber == 0) {
            result = new char[1];
            result[0] = ZERO_CHARACTER;
            return result;
        }

        int numberOfDigits = ArrayUtils.getNumberOfDigits(inputNumber);

        result = ArrayUtils.initResultArray(numberOfDigits, inputNumber);

        int startIndex = ArrayUtils.getStartIndex(numberOfDigits, inputNumber);

        convertToCharArray(ArrayUtils.convertToPositive(inputNumber), startIndex);

        return result;

    }

    private void convertToCharArray(int inputNumber, int index) {
        if (inputNumber < 10) {
            result[index] = (char) (inputNumber + DIGITS_START_INDEX);
            return;
        }

        convertToCharArray(inputNumber / 10, --index);
        result[++index] = (char) (inputNumber % 10 + DIGITS_START_INDEX);
    }

}
