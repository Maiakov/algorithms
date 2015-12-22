package com.maiakov.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintLongAlgorithmTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testPrintLongWhenInputValueIs0() throws Exception {
        long inputValue = 0;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("0", outContent.toString());
    }

    @Test
    public void testPrintLongWhenInputValueLessThen10() throws Exception {
        long inputValue = 9;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("9", outContent.toString());
    }

    @Test
    public void testPrintLongWhenInputValueIs100() throws Exception {
        long inputValue = 100;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("100", outContent.toString());
    }

    @Test
    public void testPrintLongWhenInputValueIs100500() throws Exception {
        long inputValue = 100500;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("100500", outContent.toString());
    }

    @Test
    public void testPrintLongWhenInputValueIsVeryBig() throws Exception {
        long inputValue = 9223372036854775807L;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("9223372036854775807", outContent.toString());
    }

    @Test
    public void testConvertWhenInputValueIsNegative() throws Exception {
        int inputValue = -123456;
        PrintLongAlgorithm.printLong(inputValue);
        assertEquals("-123456", outContent.toString());
    }

}