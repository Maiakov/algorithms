package com.maiakov.algorithm;

public class LexicographicalAnalyzer {

    public static String[] findBiggestAndSmallestPointers(String[] pointers) {
        if (pointers == null || pointers.length == 0) {
            throw new IllegalArgumentException("Array of pointers should contains at least one element");
        }
        String smallestPointer = pointers[0];
        String biggestPointer = pointers[0];
        for (String pointer : pointers) {
            if (pointer.compareTo(biggestPointer) < 0) {
                biggestPointer = pointer;
            } else if (pointer.compareTo(smallestPointer) > 0) {
                smallestPointer = pointer;
            }
        }
        return new String[]{smallestPointer, biggestPointer};
    }
}
