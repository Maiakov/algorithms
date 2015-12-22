package com.maiakov.charanalyzer;

import static com.maiakov.charanalyzer.BackspaceAlgorithms.*;

public class Verifier {

    public static void verify(byte[] characters, int cursor) {
        if (characters == null) {
            throw new IllegalArgumentException("Character array can not be null");
        }
        if (cursor >= characters.length) {
            throw new IllegalArgumentException("Cursor out of bound");
        }
        if (cursor == 0) {
            throw new IllegalArgumentException("Cursor points on a first element");
        }
        verifyCharactersIntegrityAndCursorPosition(characters, cursor);
    }


    private static void verifyCharactersIntegrityAndCursorPosition(byte[] characters, int cursor) {
        int cursorIterator = 0;
        boolean isCursorPositionFound = false;
        while (cursorIterator <= characters.length - 1) {
            if (characters[cursorIterator] == KANJI_SIGNIFICANT_BYTE) {
                cursorIterator = skipKanji(cursorIterator);
            } else if (characters[cursorIterator] == ASCII_SIGNIFICANT_BYTE) {
                cursorIterator = skipASCII(cursorIterator);
            }
            if (cursorIterator == cursor) {
                isCursorPositionFound = true;
            }
        }

        if (cursorIterator != characters.length) {
            throw new IllegalArgumentException("Characters array incorrect");
        }
        if (!isCursorPositionFound) {
            throw new IllegalArgumentException("Cursor position incorrect");
        }
    }


    private static int skipKanji(int cursorPosition) {
        return cursorPosition + 2;

    }

    private static int skipASCII(int cursorPosition) {
        return cursorPosition + 1;
    }
}
