package com.maiakov.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighestBitChangerAlgorithmTest {
    @Test
    public void testChangeHighestBit_0() throws Exception {
        assertEquals(0, HighestBitChangerAlgorithm.changeHighestBit(0));
    }

    @Test
    public void testChangeHighestBit_1() throws Exception {
        assertEquals(0, HighestBitChangerAlgorithm.changeHighestBit(1));
    }

    @Test
    public void testChangeHighestBit_3() throws Exception {
        assertEquals(1, HighestBitChangerAlgorithm.changeHighestBit(3));
    }

    @Test
    public void testChangeHighestBit_7() throws Exception {
        assertEquals(3, HighestBitChangerAlgorithm.changeHighestBit(7));
    }

    @Test
    public void testChangeHighestBit_15() throws Exception {
        assertEquals(7, HighestBitChangerAlgorithm.changeHighestBit(15));
    }

    @Test
    public void testChangeHighestBit_127() throws Exception {
        assertEquals(63, HighestBitChangerAlgorithm.changeHighestBit(127));
    }

    @Test
    public void testChangeHighestBit_128() throws Exception {
        assertEquals(0, HighestBitChangerAlgorithm.changeHighestBit(128));
    }
}