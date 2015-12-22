package com.maiakov.algorithm;

public class ValueAnalyzer {

    public static boolean isValuePowerOf2(int value) {
        return value == 0 ? false : (0 == (value - 1 & value));
    }

}
