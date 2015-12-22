package com.maiakov.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertArrayEquals;

public class FindDuplicatesAlgorithmTest {
    private FindDuplicatesAlgorithm findDuplicatesAlgorithm;


    @Before
    public void init() {

        findDuplicatesAlgorithm = new FindDuplicatesAlgorithm();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindDuplicatesInEmptyArray() throws Exception {
        findDuplicatesAlgorithm.findDuplicates(null);
    }

    @Test
    public void testFindDuplicatesWithOneElement() throws Exception {
        int[] inputArray = {1};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(inputArray, actualResult);
    }

    @Test
    public void testFindDuplicatesWhenAllElementsAreSame() throws Exception {
        int[] inputArray = {1, 1, 1, 1, 1};
        int[] expectedResult = {1};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindDuplicatesWithDifferentDuplicates() throws Exception {
        int[] inputArray = {1, 2, 1, 2, 3};
        int[] expectedResult = {1, 2};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindDuplicatesWhenDuplicatesInTheEnd() throws Exception {
        int[] inputArray = {1, 2, 3, 3, 3};
        int[] expectedResult = {3};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindDuplicatesWhenDuplicatesInTheBeginning() throws Exception {
        int[] inputArray = {1, 1, 3, 2};
        int[] expectedResult = {1};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindDuplicatesWithoutDuplicates() throws Exception {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expectedResult = {};
        int[] actualResult = findDuplicatesAlgorithm.findDuplicates(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }
}