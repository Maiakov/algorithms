package com.maiakov.converter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ToUpperCaseConverterTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testConvertWhenCharsArrayIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Characters array can not be empty");
        ToUpperCaseConverter.convertToUpperCase(null);
    }

    @Test
    public void testConvertWhenCharsInDifferentRegister() throws Exception {
        char[] characters = {'a', 'b', 'c', 'd', 'D'};
        char[] expectedResult = {'A', 'B', 'C', 'D', 'D'};
        char[] actualResult = ToUpperCaseConverter.convertToUpperCase(characters);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertWhenAllCharactersInLowerCase() throws Exception {
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] expectedResult = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] actualResult = ToUpperCaseConverter.convertToUpperCase(characters);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertWhenAllCharactersInHighCase() throws Exception {
        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] expectedResult = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] actualResult = ToUpperCaseConverter.convertToUpperCase(characters);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertSameChars() throws Exception {
        char[] characters = {'a', 'A', 'a', 'A', 'a'};
        char[] expectedResult = {'A', 'A', 'A', 'A', 'A'};
        char[] actualResult = ToUpperCaseConverter.convertToUpperCase(characters);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertCyrillic() throws Exception {
        char[] characters = {'а', 'н', 'Ц', 'л', 'д', 'З', 'я'};
        char[] expectedResult = {'А', 'Н', 'Ц', 'Л', 'Д', 'З', 'Я'};
        char[] actualResult = ToUpperCaseConverter.convertToUpperCase(characters);
        assertArrayEquals(expectedResult, actualResult);
    }
}