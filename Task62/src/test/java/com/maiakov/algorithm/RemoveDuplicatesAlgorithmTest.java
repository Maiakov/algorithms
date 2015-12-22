package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RemoveDuplicatesAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRemoveDuplicatesWhenArrayIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        RemoveDuplicatesAlgorithm.removeDuplicates(null);
    }

    @Test
    public void testRemoveDuplicatesWhenArrayNotSorted() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array should be sorted");
        RemoveDuplicatesAlgorithm.removeDuplicates(new int[]{4, 3, 2, 0, 2});
    }

    @Test
    public void testRemoveDuplicatesWhenArrayWithOneElement() {
        int[] inputArray = {2};
        int[] expectedArray = {2};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }

    @Test
    public void testRemoveDuplicatesWhenAllElementsAreSame() throws Exception {
        int[] inputArray = {2, 2, 2, 2, 2};
        int[] expectedArray = {2};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }

    @Test
    public void testRemoveDuplicatesWhenWhenDuplicatesInTheBeginning() throws Exception {
        int[] inputArray = {2, 2, 3, 4, 5, 6};
        int[] expectedArray = {2, 3, 4, 5, 6};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }

    @Test
    public void testRemoveDuplicatesWhenWhenDuplicatesInTheMiddle() throws Exception {
        int[] inputArray = {1, 2, 3, 3, 3, 4, 5, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }

    @Test
    public void testRemoveDuplicatesWhenWhenDuplicatesInTheEnd() throws Exception {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 6, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }


    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] inputArray = {1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 8, 99, 124};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 99, 124};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }


    @Test
    public void testRemoveDuplicatesWithNegativeNumbers() throws Exception {
        int[] inputArray = {-44, -44, -1, -1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 8, 99, 124};
        int[] expectedArray = {-44, -1, 2, 3, 4, 5, 6, 7, 8, 99, 124};
        int[] actualResult = RemoveDuplicatesAlgorithm.removeDuplicates(inputArray);
        assertArrayEquals(expectedArray, actualResult);
    }
}