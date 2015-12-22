package com.maiakov.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LongToCharArrayConverterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private LongToCharArrayConverter longToCharArrayConverter;

    @Before
    public void init() {
        longToCharArrayConverter = new LongToCharArrayConverter();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConvertWhenInputValueIs0() throws Exception {
        int inputValue = 0;
        char[] expected = {'0'};
        char[] actual = longToCharArrayConverter.convertLongNumberToCharArray(inputValue);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertWhenInputValueIs123() throws Exception {
        int inputValue = 123;
        char[] expected = {'1', '2', '3'};
        char[] actual = longToCharArrayConverter.convertLongNumberToCharArray(inputValue);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertWhenInputValueConsistsSameDigits() throws Exception {
        int inputValue = 22222;
        char[] expected = {'2', '2', '2', '2', '2'};
        char[] actual = longToCharArrayConverter.convertLongNumberToCharArray(inputValue);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertWhenInputValueIsNegative() throws Exception {
        int inputValue = -123456;
        char[] expected = {'-','1', '2', '3', '4', '5', '6'};
        char[] actual = longToCharArrayConverter.convertLongNumberToCharArray(inputValue);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertWhenInputValueMaxInt() throws Exception {
        int inputValue = Integer.MAX_VALUE;
        char[] expected = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
        char[] actual = longToCharArrayConverter.convertLongNumberToCharArray(inputValue);
        assertArrayEquals(expected, actual);
    }
}