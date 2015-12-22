package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CustomSortAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSortWithNullArray() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        CustomSortAlgorithm.sort(null, 5);
    }

    @Test
    public void testSortWhenBoundOutOfRange() throws Exception {
        int[] inputArray = {1};
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bound out of array length");
        CustomSortAlgorithm.sort(inputArray, 2);
    }

    @Test
    public void testSortWhenBoundIncorrect() throws Exception {
        int[] inputArray = {1, 1, 1};
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Incorrect bound");
        CustomSortAlgorithm.sort(inputArray, 2);
    }

    @Test
    public void testSortAllElements() throws Exception {
        int[] inputArray = {1, 4, 5, 2, 3, 3, 3};
        int[] expectedArray = {1, 2, 3, 3, 3};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 5));
    }

    @Test
    public void testSortWithOneElement() throws Exception {
        int[] inputArray = {1};
        int[] expectedArray = {1};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 1));
    }

    @Test
    public void testSortWithTwoElements() throws Exception {
        int[] inputArray = {2, 1};
        int[] expectedArray = {1, 2};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 2));
    }

    @Test
    public void testSortWithThreeElements() throws Exception {
        int[] inputArray = {2, 1, 1};
        int[] expectedArray = {1, 1};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 2));
    }

    @Test
    public void testSortHugeArray() throws Exception {
        int[] inputArray = {2, 1, 1, 2, 2, 2, 4, 4, 4, 4, 5, 2, 4, 3, 3, 7, 7, 8, 5, 6};
        int[] expectedArray = {1, 1, 2, 2, 2, 2, 2, 3};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 8));
    }

    @Test
    public void testSortWhenAllElementsAreSame() throws Exception {
        int[] inputArray = {2, 2, 2, 2, 2, 2, 2, 2,};
        int[] expectedArray = {2, 2};
        assertArrayEquals(expectedArray, CustomSortAlgorithm.sort(inputArray, 2));
    }
}