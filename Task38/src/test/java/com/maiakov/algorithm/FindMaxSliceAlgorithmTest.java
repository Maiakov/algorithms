package com.maiakov.algorithm;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

public class FindMaxSliceAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private com.maiakov.algorithm.FindMaxSliceAlgorithm FindMaxSliceAlgorithm;

    @Before
    public void init() {
        FindMaxSliceAlgorithm = new com.maiakov.algorithm.FindMaxSliceAlgorithm();
    }

    @Test
    public void testSolutionWithEmptyArray() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can`t be empty");
        FindMaxSliceAlgorithm.findMaxSlice(new int[0]);
    }

    @Test
    public void testSolutionWithNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can`t be null");
        FindMaxSliceAlgorithm.findMaxSlice(null);
    }


    @Test
    public void testWithOneElement() throws Exception {
        int[] inputArray = {1};
        int[] expectedResult = inputArray;
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWith10PositiveElementsInAscOrder() throws Exception {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expectedResult = inputArray;
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWith10PositiveElementsInDescOrder() throws Exception {
        int[] inputArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedResult = inputArray;
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWith10NegativeElementsInAscOrder() throws Exception {
        int[] inputArray = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        int[] expectedResult = {-1};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWith10NegativeElementsInDescOrder() throws Exception {
        int[] inputArray = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
        int[] expectedResult = {-1};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWithRandomElements1() throws Exception {
        int[] inputArray = {-5, 6, 7, 8, -9, -10};
        int[] expectedResult = {6, 7, 8};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWithRandomElements2() throws Exception {
        int[] inputArray = {-5, 6, 7, 8, -9, -10, 100};
        int[] expectedResult = {6, 7, 8, -9, -10, 100};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWithOnePositiveElement() throws Exception {
        int[] inputArray = {-5, -6, -7, -8, -9, 10};
        int[] expectedResult = {10};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWithAllSameNegativeElements() throws Exception {
        int[] inputArray = {-1, -1, -1, -1};
        int[] expectedResult = {-1};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }

    @Test
    public void testWithTwoMaxSlices() throws Exception {
        int[] inputArray = {1,2,3,-100,1,2,3};
        int[] expectedResult = {1,2,3};
        assertArrayEquals(expectedResult, FindMaxSliceAlgorithm.findMaxSlice(inputArray));
    }


}