package com.maiakov.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitsReversalAlgorithmTest {
    @Test
    public void testReverseBits_0() throws Exception {
        assertEquals(1, BitsReversalAlgorithm.reverseBits(0));
    }

    @Test
    public void testReverseBits_1() throws Exception {
        assertEquals(1, BitsReversalAlgorithm.reverseBits(1));
    }

    @Test
    public void testReverseBits_2() throws Exception {
        assertEquals(2, BitsReversalAlgorithm.reverseBits(2));
    }

    @Test
    public void testReverseBits_6() throws Exception {
        assertEquals(4, BitsReversalAlgorithm.reverseBits(6));
    }

    @Test
    public void testReverseBits_7() throws Exception {
        assertEquals(0, BitsReversalAlgorithm.reverseBits(7));
    }

    @Test
    public void testReverseBits_8() throws Exception {
        assertEquals(14, BitsReversalAlgorithm.reverseBits(8));
    }

    @Test
    public void testReverseBits_10() throws Exception {
        assertEquals(10, BitsReversalAlgorithm.reverseBits(10));
    }

    @Test
    public void testReverseBits_16() throws Exception {
        assertEquals(30, BitsReversalAlgorithm.reverseBits(16));
    }

    @Test
    public void testReverseBits_127() throws Exception {
        assertEquals(0, BitsReversalAlgorithm.reverseBits(127));
    }

    @Test
    public void testReverseBits_128() throws Exception {
        assertEquals(254, BitsReversalAlgorithm.reverseBits(128));
    }
}