package com.maiakov.algorithm;

public class PrintLongAlgorithm {
    private static final int DIGITS_START_INDEX = 48;

    public static void printLong(long inputNumber) {
        if (inputNumber < 0) {
            printChar('-');
            inputNumber = -1 * inputNumber;
        }
        if (inputNumber < 10) {
            printChar((char) (inputNumber + DIGITS_START_INDEX));
            return;
        }
        printLong(inputNumber / 10);
        printChar((char) (inputNumber % 10 + DIGITS_START_INDEX));
    }

    private static void printChar(char number) {
        System.out.print(number);
    }
}
