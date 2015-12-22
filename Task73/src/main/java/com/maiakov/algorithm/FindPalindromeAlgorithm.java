package com.maiakov.algorithm;

public class FindPalindromeAlgorithm {
    public static boolean isStringPalindrome(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Input string can not be null");
        }
        if (inputString.length() == 0) {
            return false;
        }
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
