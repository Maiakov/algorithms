package com.maiakov.charanalyzer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BackspaceAlgorithmsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDoBackspaceWhenCharactersArrayIsNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Character array can not be null");
        BackspaceAlgorithms.doBackspace(null, 1);
    }

    @Test
    public void testDoBackspaceWhenCursorOutOfBound() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cursor out of bound");
        int cursor = 1;
        BackspaceAlgorithms.doBackspace(new byte[]{0}, cursor);
    }


    @Test
    public void testDoBackspaceWhenCursorPointsOnFirstElement() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cursor points on a first element");
        int cursor = 0;
        BackspaceAlgorithms.doBackspace(new byte[]{1}, cursor);
    }


    @Test
    public void testDoBackspaceWhenCursorIncorrect() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cursor position incorrect");
        int cursor = 3;
        byte[] characters = new byte[]{1, 1, 1, 1};

        BackspaceAlgorithms.doBackspace(characters, cursor);
    }

    @Test
    public void testDoBackspaceWhenInputArrayIncorrect() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Characters array incorrect");
        int cursor = 3;
        byte[] characters = new byte[]{1, 1, 1, 1, 1};

        BackspaceAlgorithms.doBackspace(characters, cursor);
    }

    @Test
    public void testDoBackspaceWhenOnlyACSIIAndCursorOnLastElement() throws Exception {
        byte[] characters = new byte[]{0, 0, 0, 0, 0};
        byte[] charactersWithBackspace = new byte[]{0, 0, 0, 0};
        int cursor = 4;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceWhenOnlyACSIIAndCursorInTheMiddle() throws Exception {
        byte[] characters = new byte[]{0, 0, 0, 0, 0};
        byte[] charactersWithBackspace = new byte[]{0, 0, 0, 0};
        int cursor = 2;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceWhenOnlyKANJIAndCursorInTheMiddle() throws Exception {
        byte[] characters = new byte[]{1, 1, 1, 1, 1, 1};
        byte[] charactersWithBackspace = new byte[]{1, 1, 1, 1};
        int cursor = 2;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceWhenOnlyKANJIAndCursorOnTheLastElement() throws Exception {
        byte[] characters = new byte[]{1, 1, 1, 1, 1, 1, 0};
        byte[] charactersWithBackspace = new byte[]{1, 1, 1, 1, 0};
        int cursor = 6;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceForKANJIElement() throws Exception {
        byte[] characters = new byte[]{1, 0, 1, 0, 1, 1, 0};
        byte[] charactersWithBackspace = new byte[]{1, 0, 1, 0, 0};
        int cursor = 6;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceForKANJIElementAndNeedGoToBeginning() throws Exception {
        byte[] characters = new byte[]{0, 1, 1, 1, 1, 1, 1, 1, 0};
        byte[] charactersWithBackspace = new byte[]{0, 1, 1, 1, 1, 1, 0};
        int cursor = 7;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceForASCIIElement() throws Exception {
        byte[] characters = new byte[]{0, 1, 1, 1, 1, 0, 1, 0};
        byte[] charactersWithBackspace = new byte[]{0, 1, 1, 1, 1, 1, 0};
        int cursor = 6;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceForASCIIElementAndNeedGoToBeginning() throws Exception {
        byte[] characters = new byte[]{0, 1, 1, 1, 1, 1, 0, 1, 0};
        byte[] charactersWithBackspace = new byte[]{0, 1, 1, 1, 1, 1, 1, 0};
        int cursor = 7;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }

    @Test
    public void testDoBackspaceForASCIIElementAndNeedGoToBeginning2() throws Exception {
        byte[] characters = new byte[]{1, 1, 1, 1, 1, 1, 0, 1, 0};
        byte[] charactersWithBackspace = new byte[]{1, 1, 1, 1, 1, 1, 1, 0};
        int cursor = 7;
        byte[] actualResult = BackspaceAlgorithms.doBackspace(characters, cursor);

        assertArrayEquals(charactersWithBackspace, actualResult);
    }
}