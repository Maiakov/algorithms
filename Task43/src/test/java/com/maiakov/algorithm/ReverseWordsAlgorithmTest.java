package com.maiakov.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.maiakov.algorithm.ReverseWordsAlgorithm.SPACE;

public class ReverseWordsAlgorithmTest {


    @Test
    public void testReverseWholeCharsArray() throws Exception {
        char[] inputWords = {'H', 'e', 'l', 'l', 'o', SPACE,
                'w', 'o', 'r', 'l', 'd'};
        ReverseWordsAlgorithm.reverseCharsArray(inputWords, 0, inputWords.length);
        char[] expectedResult = {'d', 'l', 'r', 'o', 'w', SPACE,
                'o', 'l', 'l', 'e', 'H'};
        assertArrayEquals(expectedResult, inputWords);
    }

    @Test
    public void testSkipSpacesInTheMiddle() throws Exception {
        char[] inputWords = {'H', SPACE, SPACE, 'w'};
        int actualResult = ReverseWordsAlgorithm.skipSpaces(inputWords, 1);
        assertEquals(3, actualResult);
    }

    @Test
    public void testSkipSpacesInTheEnd() throws Exception {
        char[] inputWords = {'H', SPACE, SPACE};
        int actualResult = ReverseWordsAlgorithm.skipSpaces(inputWords, 1);
        assertEquals(2, actualResult);
    }

    @Test
    public void testSkipSpacesInTheBeginning() throws Exception {
        char[] inputWords = {SPACE, SPACE, 'A'};
        int actualResult = ReverseWordsAlgorithm.skipSpaces(inputWords, 0);
        assertEquals(2, actualResult);
    }

    @Test
    public void testReverse2Words() throws Exception {
        char[] inputWords = {'H', 'e', 'l', 'l', 'o', SPACE,
                'w', 'o', 'r', 'l', 'd'};
        char[] actualResult = ReverseWordsAlgorithm.reverseWords(inputWords);
        char[] expectedResult = {'w', 'o', 'r', 'l', 'd', SPACE, 'H', 'e', 'l', 'l', 'o'};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse3Words() throws Exception {
        char[] inputWords = {'H', 'e', 'l', 'l', 'o', SPACE,
                'm', 'y', SPACE,
                'w', 'o', 'r', 'l', 'd'};
        char[] actualResult = ReverseWordsAlgorithm.reverseWords(inputWords);
        char[] expectedResult = {'w', 'o', 'r', 'l', 'd', SPACE,
                'm', 'y', SPACE,
                'H', 'e', 'l', 'l', 'o'};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse5Words() throws Exception {
        char[] inputWords = {'H', 'e', 'l', 'l', 'o', SPACE,
                'm', 'y', SPACE,
                'w', 'o', 'n', 'd', 'e', 'r', 'f', 'u', 'l', SPACE,
                's', 'a', 'd', SPACE,
                'w', 'o', 'r', 'l', 'd'};
        char[] actualResult = ReverseWordsAlgorithm.reverseWords(inputWords);
        char[] expectedResult = {'w', 'o', 'r', 'l', 'd', SPACE,
                's', 'a', 'd', SPACE,
                'w', 'o', 'n', 'd', 'e', 'r', 'f', 'u', 'l', SPACE,
                'm', 'y', SPACE,
                'H', 'e', 'l', 'l', 'o'};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse2WordsWithManySpacesBetweenWords() throws Exception {
        char[] inputWords = {'H', 'e', 'l', 'l', 'o', SPACE, SPACE, SPACE, 'w', 'o', 'r', 'l', 'd'};
        char[] actualResult = ReverseWordsAlgorithm.reverseWords(inputWords);
        char[] expectedResult = {'w', 'o', 'r', 'l', 'd', SPACE, SPACE, SPACE, 'H', 'e', 'l', 'l', 'o'};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse2WordsWithSpacesOnTheBounds() throws Exception {
        char[] inputWords = {SPACE, SPACE, SPACE,
                'H', 'e', 'l', 'l', 'o', SPACE,
                'w', 'o', 'r', 'l', 'd'};
        char[] actualResult = ReverseWordsAlgorithm.reverseWords(inputWords);
        char[] expectedResult = {SPACE, SPACE, SPACE,
                'w', 'o', 'r', 'l', 'd', SPACE,
                'H', 'e', 'l', 'l', 'o'};

        assertArrayEquals(expectedResult, actualResult);
    }


}