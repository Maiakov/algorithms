package com.maiakov.algorithm.utils;

import com.maiakov.algorithm.utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void testInitResultArrayForNegativeNumber() throws Exception {
        int inputNumber = -123;
        char[] expectedResult = new char[4];
        expectedResult[0] = '-';
        assertArrayEquals(expectedResult, ArrayUtils.initResultArray(3, inputNumber));
    }
    @Test
    public void testInitResultArrayForNumber() throws Exception {
        int inputNumber = 123;
        char[] expectedResult = new char[3];
        assertArrayEquals(expectedResult, ArrayUtils.initResultArray(3,inputNumber));
    }


    @Test
    public void testGetStartIndexForPositiveNumber() throws Exception {
        assertEquals(4, ArrayUtils.getStartIndex(5, 12345));
    }

    @Test
    public void testGetStartIndexForNegativeNumber() throws Exception {
        assertEquals(5, ArrayUtils.getStartIndex(5, -12345));
    }

    @Test
    public void testNumberOfDigitsWhenInputIs10() throws Exception {
        int inputValue = 10;
        int actual = ArrayUtils.getNumberOfDigits(inputValue);
        assertEquals(2, actual);
    }

    @Test
    public void testNumberOfDigitsWhenInputIs100() throws Exception {
        int inputValue = 100;
        int actual = ArrayUtils.getNumberOfDigits(inputValue);
        assertEquals(3, actual);
    }

}