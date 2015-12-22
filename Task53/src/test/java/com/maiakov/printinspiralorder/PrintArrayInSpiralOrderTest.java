package com.maiakov.printinspiralorder;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintArrayInSpiralOrderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintArrayInSpiralOrder printArrayInSpiralOrder;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        printArrayInSpiralOrder = new PrintArrayInSpiralOrder();
    }

    @Test
    public void testPrintArray1x1() {
        int[][] array = new int[][]{{1}};
        String expectedResult = "1 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray2x2() {
        int[][] array = new int[][]{{1, 2},{1,2}};
        String expectedResult = "1 2 2 1 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray3x3() {
        int[][] array = new int[][]{{1, 2 ,3},
                                    {1, 2 ,3},
                                    {1, 2 ,3}};
        String expectedResult = "1 2 3 3 3 2 1 1 2 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray5x5() {
        int[][] array = new int[][]{{1, 2, 3, 4, 5},
                                    {1, 2, 3, 4, 5},
                                    {1, 2, 3, 4, 5},
                                    {1, 2, 3, 4, 5},
                                    {1, 2, 3, 4, 5}};
        String expectedResult = "1 2 3 4 5 5 5 5 5 4 3 2 1 1 1 1 2 3 4 4 4 3 2 2 3 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray7x7() {
        int[][] array = new int[][]{{1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7},
                                    {1, 2, 3, 4, 5, 6, 7}};
        String expectedResult = "1 2 3 4 5 6 7 7 7 7 7 7 7 6 5 4 3 2 1 1 1 1 1 1 2 3 4 5 6 6 6 6 6 5 4 3 2 2 2 2 3 4 5 5 5 4 3 3 4 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintWhenArrayIsNull() {
        int[][] array = null;
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        printArrayInSpiralOrder.print(array);
    }

    @Test
    public void testPrintWhenArrayIsEmpty() {
        int[][] array = new int[][]{};
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        printArrayInSpiralOrder.print(array);
    }

    @Test
    public void testPrintArray2x3() {
        int[][] array = new int[][]{{1, 2},
                                    {1, 2},
                                    {1, 2}};
        String expectedResult = "1 2 2 2 1 1 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray3x2() {
        int[][] array = new int[][]{{1, 2,3},
                                    {1, 2,3}};
        String expectedResult = "1 2 3 3 2 1 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintArray4x2() {
        int[][] array = new int[][]{{1, 2,3,4},
                                    {1, 2,3,4}};
        String expectedResult = "1 2 3 4 4 3 2 1 ";
        printArrayInSpiralOrder.print(array);
        assertEquals(expectedResult, outContent.toString());
    }

}