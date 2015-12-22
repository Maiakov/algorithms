package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SumComputationAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSumForArrayWithDifferentSign() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Array for second form can not contain both positive and negative digits");
        int[] inputArray = {1, 2, 3, -1, 2};
        SumComputationAlgorithm.sumForSecondForm(inputArray);
    }

    @Test
    public void testSumForNullArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array cont not be null");
        SumComputationAlgorithm.sumForSecondForm(null);
    }


    @Test
    public void testSumForNegativeNumbers() throws Exception {
        int[] inputArray = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};
        int sum = SumComputationAlgorithm.sum(inputArray);
        assertEquals(-45, sum);
    }

    @Test
    public void testSumForPositiveNumbers() throws Exception {
        int[] inputArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = SumComputationAlgorithm.sum(inputArray);
        assertEquals(45, sum);
    }

    @Test
    public void testSumForAnyNumbers() throws Exception {
        int[] inputArray = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, -9};
        int sum = SumComputationAlgorithm.sum(inputArray);
        assertEquals(5, sum);
    }

    @Test
    public void testSumForSecondFormForNegativeNumbers() throws Exception {
        int[] arrayInNormalForm = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};
        int[] arrayInSecondComplementForm = convertToSecondComplement(arrayInNormalForm, 10);
        int sum = SumComputationAlgorithm.sumForSecondForm(arrayInSecondComplementForm);
        assertEquals(45, sum);
    }

    @Test
    public void testSumForSecondFormWithOneElement() throws Exception {
        int[] arrayInNormalForm = new int[]{-1};
        int[] arrayInSecondComplementForm = convertToSecondComplement(arrayInNormalForm, 10);
        int sum = SumComputationAlgorithm.sumForSecondForm(arrayInSecondComplementForm);
        assertEquals(9, sum);
    }

    @Test
    public void testSumFormWithOneElement() throws Exception {
        int[] arrayInNormalForm = new int[]{-1};
        int sum = SumComputationAlgorithm.sumForSecondForm(arrayInNormalForm);
        assertEquals(-1, sum);
    }

    private static int[] convertToSecondComplement(int[] array, int overflowValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = overflowValue + array[i];
            }
        }
        return array;
    }
}