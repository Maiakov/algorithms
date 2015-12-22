package com.maiakov.algorithm;


public class Random {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    public static int getRandomNumber(int bound) {
        long seed = (System.nanoTime() % bound);
        for (int i = 0; i < bound; i++) {

            seed = ((multiplier * seed + addend) % bound + 1);
        }
        if (seed == 0) {
            System.out.println("a");
        }
        return (int) seed;
    }


}
