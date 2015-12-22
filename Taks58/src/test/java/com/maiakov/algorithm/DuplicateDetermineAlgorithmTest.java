package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DuplicateDetermineAlgorithmTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIsContainsDuplicatesWithNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        DuplicateDetermineAlgorithm.isContainsDuplicate(null);
    }

    @Test
    public void testIsContainsDuplicatesWithEmptyArray() {
        int[] inputArray = new int[]{};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertFalse(expectedResult);
    }

    @Test
    public void testIsContainsDuplicatesWithArrayFromOneElement() {
        int[] inputArray = new int[]{1};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertFalse(expectedResult);
    }

    @Test
    public void testIsContainsDuplicateWithoutDuplicates() throws Exception {
        int[] inputArray = new int[]{1, 2, 3, 4};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertFalse(expectedResult);
    }

    @Test
    public void testIsContainsDuplicateWithDuplicatesInTheBeginning() throws Exception {
        int[] inputArray = new int[]{1, 1, 2, 3, 4, 6};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertTrue(expectedResult);
    }

    @Test
    public void testIsContainsDuplicateWithDuplicatesInTheMiddle() throws Exception {
        int[] inputArray = new int[]{1, 2, 3, 3, 4, 6};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertTrue(expectedResult);
    }

    @Test
    public void testIsContainsDuplicateWithDuplicatesInTheEnd() throws Exception {
        int[] inputArray = new int[]{1, 2, 3, 4, 6, 6};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertTrue(expectedResult);
    }

    @Test
    public void testIsContainsDuplicateInHugeArray() throws Exception {
        int[] inputArray = new int[]{3, 2, 1, 5, 6, 7, 8, 9, 10, 4, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20};
        boolean expectedResult = DuplicateDetermineAlgorithm.isContainsDuplicate(inputArray);
        assertTrue(expectedResult);
    }
}