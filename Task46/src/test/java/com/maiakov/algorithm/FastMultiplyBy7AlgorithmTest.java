package com.maiakov.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class FastMultiplyBy7AlgorithmTest {
    @Test
    public void testMultiply7By0() throws Exception {
        int inputNumber = 0;
        int expected = inputNumber * 7;
        assertEquals(expected, FastMultiplyBy7Algorithm.multiplyBy7(inputNumber));
    }

    @Test
    public void testMultiply7By1() throws Exception {
        int inputNumber = 1;
        int expected = inputNumber * 7;
        assertEquals(expected, FastMultiplyBy7Algorithm.multiplyBy7(inputNumber));
    }

    @Test
    public void testMultiply7By2() throws Exception {
        int inputNumber = 2;
        int expected = inputNumber * 7;
        assertEquals(expected, FastMultiplyBy7Algorithm.multiplyBy7(inputNumber));
    }

    @Test
    public void testMultiply7By100() throws Exception {
        int inputNumber = 100;
        int expected = inputNumber * 7;
        assertEquals(expected, FastMultiplyBy7Algorithm.multiplyBy7(inputNumber));
    }

    @Test
    public void testMultiply7ByNegativeNumber() throws Exception {
        int inputNumber = -10;
        int expected = inputNumber * 7;
        assertEquals(expected, FastMultiplyBy7Algorithm.multiplyBy7(inputNumber));
    }
}