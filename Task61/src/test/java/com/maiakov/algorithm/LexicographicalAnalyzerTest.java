package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LexicographicalAnalyzerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFindBiggestAndSmallestPointers_WithNullArray() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Array of pointers should contains at least one element");
        LexicographicalAnalyzer.findBiggestAndSmallestPointers(null);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithEmptyArray() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Array of pointers should contains at least one element");
        LexicographicalAnalyzer.findBiggestAndSmallestPointers(null);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithOneElement() throws Exception {
        String[] inputArray = {"a"};
        String[] expectedResult = {"a", "a"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithTwoElements() throws Exception {
        String smallestElement = "a";
        String biggestElement = "AB";
        String[] inputArray = {biggestElement, smallestElement};
        String[] expectedResult = {smallestElement, biggestElement};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithSameElements() throws Exception {
        String element = "a";
        String[] inputArray = {element, element, element, element};
        String[] expectedResult = {element, element};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithManyElements() throws Exception {
        String[] inputArray = {"applу", "bear", "zoo", "app", "bread"};
        String[] expectedResult = {"zoo", "app"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithManyElements2() throws Exception {
        String[] inputArray = {"a", "A", "Aa", "bzz", "z", "Z"};
        String[] expectedResult = {"z", "A"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithManyElements3() throws Exception {
        String[] inputArray = {"APPLУ", "BEAR", "ZOO", "APP", "BREAD"};
        String[] expectedResult = {"ZOO", "APP"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithManyElements4() throws Exception {
        String[] inputArray = {"APPLУ", "BEAR", "ZOO", "APP", "BREAD"};
        String[] expectedResult = {"ZOO", "APP"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindBiggestAndSmallestPointers_WithManyElements5() throws Exception {
        String[] inputArray = {"aaaA", "bbbA", "zzzA", "z", "Z"};
        String[] expectedResult = {"zzzA", "Z"};
        String[] actualResult = LexicographicalAnalyzer.findBiggestAndSmallestPointers(inputArray);
        assertArrayEquals(expectedResult, actualResult);
    }

}