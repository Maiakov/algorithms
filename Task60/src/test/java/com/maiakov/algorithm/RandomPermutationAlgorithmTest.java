package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class RandomPermutationAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

     @Test
    public void testRandomPermutationWithNullArray() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input array can not be null");
        RandomPermutationAlgorithm.randomPermutation(null);
    }

    @Test
    public void testRandomPermutation10000Times() throws Exception {
        int[][] resultsHistory = new int[10000][52];
        for (int i = 0; i < 10000; i++) {
            int[] actualResult = RandomPermutationAlgorithm.randomPermutation(prepareRandomArray());
            assertWithPreviousResults(resultsHistory, actualResult);
            resultsHistory[i] = actualResult;
        }
    }

    private void assertWithPreviousResults(int[][] resultsHistory, int[] currentResult) {
        for (int i = 0; i < resultsHistory.length; i++) {
            assertThat(currentResult, not(equalTo(resultsHistory[i])));
        }
    }

    private static int[] prepareRandomArray() {
        int[] cards = new int[100];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }
        return cards;
    }
}