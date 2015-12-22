package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class FindPalindromeAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIsStringPalindrome_withNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input string can not be null");
        assertTrue(FindPalindromeAlgorithm.isStringPalindrome(null));
    }

    @Test
    public void testIsStringPalindrome_withEmptyString() throws Exception {
        assertFalse(FindPalindromeAlgorithm.isStringPalindrome(""));
    }

    @Test
    public void testIsStringPalindrome_withPalindrome1() throws Exception {
        assertTrue(FindPalindromeAlgorithm.isStringPalindrome("aa"));
    }

    @Test
    public void testIsStringPalindrome_withPalindrome2() throws Exception {
        assertTrue(FindPalindromeAlgorithm.isStringPalindrome("toyot"));
    }

    @Test
    public void testIsStringPalindrome_withPalindrome3() throws Exception {
        assertTrue(FindPalindromeAlgorithm.isStringPalindrome("ffffaaffff"));
    }

    @Test
    public void testIsStringPalindrome_withOneLetter() throws Exception {
        assertTrue(FindPalindromeAlgorithm.isStringPalindrome("a"));
    }

    @Test
    public void testIsStringPalindrome_withoutPalindrome() throws Exception {
        assertFalse(FindPalindromeAlgorithm.isStringPalindrome("abab"));
    }

    @Test
    public void testIsStringPalindrome_withoutPalindrome2() throws Exception {
        assertFalse(FindPalindromeAlgorithm.isStringPalindrome("aaaabaaa"));
    }
}