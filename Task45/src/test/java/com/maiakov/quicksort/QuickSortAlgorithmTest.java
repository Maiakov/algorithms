package com.maiakov.quicksort;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class QuickSortAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testSortWithEmptyArray() throws Exception {
        int[] inputArray = new int[0];
        QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(inputArray, inputArray);
    }

    @Test
    public void testSortWithNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can`t be null");
        QuickSortAlgorithm.sort(null);
    }

    @Test
    public void testSortWithSingleElementInArray() throws Exception {
        int[] inputArray = new int[1];
        int[] actualArray = QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(inputArray, actualArray);
    }

    @Test
    public void testSortWithSortedArray() throws Exception {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int[] actualArray = QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(inputArray, actualArray);
    }

    @Test
    public void testSortWithUnsortedArray() throws Exception {
        int[] inputArray = {8, 1, 2, 53, 3, 4, 5, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 8, 53};
        int[] actualArray = QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSortArrayWithDuplicates() throws Exception {
        int[] inputArray = {1, 1, 222, 53, 53, 53};
        int[] expectedArray = {1, 1, 53, 53, 53, 222};
        int[] actualArray = QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSortArrayWithNegativeElements() throws Exception {
        int[] inputArray = {1, 1, -222, -53, 53, 53};
        int[] expectedArray = {-222, -53, 1, 1, 53, 53};
        int[] actualArray = QuickSortAlgorithm.sort(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }
}