package com.maiakov.algorithm;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueAnalyzerTest {
    @Test
    public void testIsValuePowerOf2WhenInputValueIs1() throws Exception {
        assertTrue(ValueAnalyzer.isValuePowerOf2(1));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs2() throws Exception {
        assertTrue(ValueAnalyzer.isValuePowerOf2(2));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs4() throws Exception {
        assertTrue(ValueAnalyzer.isValuePowerOf2(4));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs16() throws Exception {
        assertTrue(ValueAnalyzer.isValuePowerOf2(16));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs512() {
        assertTrue(ValueAnalyzer.isValuePowerOf2(512));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs1024() {
        assertTrue(ValueAnalyzer.isValuePowerOf2(1024));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs3() {
        assertFalse(ValueAnalyzer.isValuePowerOf2(3));
    }

    @Test
    public void testIsValuePowerOf2WhenInputValueIs0() {
        assertFalse(ValueAnalyzer.isValuePowerOf2(0
        ));
    }

}