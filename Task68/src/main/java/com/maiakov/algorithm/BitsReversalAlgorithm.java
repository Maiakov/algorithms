package com.maiakov.algorithm;


public class BitsReversalAlgorithm {

    public static int reverseBits(int number) {
        if(number == 1){
            return number;
        }
        if(number ==0 ){
            return 1;
        }
        int revertedFromLeftToRight = swapFromLeftToRight(number);
        int closestPowerOf2 = findClosestPowerOf2(number);
        return revertedFromLeftToRight ^ ((closestPowerOf2 << 1) - 1);
    }

    private static int swapFromLeftToRight(int number) {
        int revertedFromLeftToRight = 0;
        while (number != 0) {
            revertedFromLeftToRight <<= 1;
            revertedFromLeftToRight |= (number & 1);
            number >>= 1;
        }
        return revertedFromLeftToRight;
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
