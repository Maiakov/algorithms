package com.maiakov.stringchecker;

import com.sun.deploy.util.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FindStringEntryAlgorithmsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private static final String EMPTY_STRING = "";

    @Test
    public void testGetDeletedCharactersWhenS1IsNull() {
        String s1 = null;
        String s2 = "abgtop";
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input string can not be null");
        FindStringEntryAlgorithms.getDeletedCharacters(s1, s2);
    }

    @Test
    public void testGetDeletedCharactersWhenS2IsNull() {
        String s1 = "sd";
        String s2 = null;
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input string can not be null");
        FindStringEntryAlgorithms.getDeletedCharacters(s1, s2);
    }

    @Test
    public void testGetDeletedCharactersWhenCommonCharactersInDifferentPlaces() {
        String s1 = "abcdefg";
        String s2 = "abgtop";
        String expectedResult = "abg";
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenS1IsEmpty() {
        String s1 = EMPTY_STRING;
        String s2 = "abgtop";
        String expectedResult = EMPTY_STRING;
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenS2IsEmpty() {
        String s1 = "abcdefg";
        String s2 = EMPTY_STRING;
        String expectedResult = EMPTY_STRING;
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenS2AndS1AreEmpty() {
        String s1 = EMPTY_STRING;
        String s2 = EMPTY_STRING;
        String expectedResult = EMPTY_STRING;
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenCommonCharsAtBeginning() {
        String s1 = "abcert";
        String s2 = "abcpol";
        String expectedResult = "abc";
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenCommonCharsAtTheEnd() {
        String s1 = "qwerty";
        String s2 = "abcpasdrty";
        String expectedResult = "rty";
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWhenS1AndS2AreSame() {
        String s1 = "qwerty";
        String s2 = "qwerty";
        String expectedResult = "qwerty";
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

    @Test
    public void testGetDeletedCharactersWithDuplicates() {
        String s1 = "aaaaabbbbb";
        String s2 = "aabbcc";
        String expectedResult = "aabb";
        assertEquals(expectedResult, FindStringEntryAlgorithms.getDeletedCharacters(s1, s2));
    }

}