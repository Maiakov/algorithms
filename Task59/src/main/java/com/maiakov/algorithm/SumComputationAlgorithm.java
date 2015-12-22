package com.maiakov.algorithm;

public class SumComputationAlgorithm {
    public static int sum(int[] array) {
        baseValidation(array);
        return getSum(array);
    }

    public static int sumForSecondForm(int[] array) {
        validatorForSecondForm(array);
        return getSum(array);
    }


    private static int getSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }


    private static void baseValidation(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Input array cont not be null");
        }
    }

    private static void validatorForSecondForm(int[] array) {
        baseValidation(array);

        boolean arraySign = isPositive(array[0]);
        for (int i = 0; i < array.length; i++) {
            if (arraySign != isPositive(array[i])) {
                throw new IllegalArgumentException("Array for second form can not contain both positive and negative digits");
            }
        }
    }

    private static boolean isPositive(int value) {
        return value > 0;
    }

}
