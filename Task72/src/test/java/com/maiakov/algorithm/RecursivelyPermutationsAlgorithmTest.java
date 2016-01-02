package com.maiakov.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class RecursivelyPermutationsAlgorithmTest {
    private static final String NEXT_PERMUTATION = "\n";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final BasePermutationsAlgorithm algorithm = new RecursivelyPermutationsAlgorithm();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testRecursivelyPermutation_1x1() throws Exception {
        String[][] inputArray = {{"1"}, {"2"}};
        algorithm.printAllPermutations(inputArray);
        int countOfGeneratedPermutations = new HashSet(Arrays.asList(outContent.toString().split(NEXT_PERMUTATION))).size();
        int expectedCountOfPermutations = 2;
        assertEquals(expectedCountOfPermutations, countOfGeneratedPermutations);
    }

    @Test
    public void testRecursivelyPermutation_2x2() throws Exception {
        String[][] inputArray = {{"1", "2"}, {"3", "4"}};
        algorithm.printAllPermutations(inputArray);
        int countOfGeneratedPermutations = new HashSet(Arrays.asList(outContent.toString().split(NEXT_PERMUTATION))).size();
        int expectedCountOfPermutations = 24;
        assertEquals(expectedCountOfPermutations, countOfGeneratedPermutations);
    }

    @Test
    public void testRecursivelyPermutation_3x3() throws Exception {
        String[][] inputArray = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        algorithm.printAllPermutations(inputArray);
        int countOfGeneratedPermutations = new HashSet(Arrays.asList(outContent.toString().split(NEXT_PERMUTATION))).size();
        int expectedCountOfPermutations = 362880;
        assertEquals(expectedCountOfPermutations, countOfGeneratedPermutations);
    }

}