package com.maiakov.algorithm;


public class HighestBitChangerAlgorithm {

    public static int changeHighestBit(int value) {
        int closestPowerOf2 = findClosestPowerOf2(value);
        return value ^ closestPowerOf2;
    }

    private static int findClosestPowerOf2(int value) {
        int maxPowerOf2 = 1 << 30;
        while (true) {
            if ((maxPowerOf2 & value) == maxPowerOf2) {
                break;
            }
            maxPowerOf2 >>= 1;
        }
        return maxPowerOf2;
    }

}
