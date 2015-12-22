package com.maiakov.charanalyzer;

public class BackspaceAlgorithms {

    public static final int KANJI_SIGNIFICANT_BYTE = 1;
    public static final int ASCII_SIGNIFICANT_BYTE = 0;

    public static byte[] doBackspace(byte[] characters, int cursor) {
        Verifier.verify(characters, cursor);
        if (isKanji(characters[cursor - 1])) {
            return removeKANJI(characters, cursor);
        }
        int countOfKanjiSignificantBits = findEndOfPreviousCharacter(characters, cursor);
        byte[] charactersWithBackspace = removeCharacter(characters, cursor, countOfKanjiSignificantBits);
        return charactersWithBackspace;

    }

    private static int findEndOfPreviousCharacter(byte[] characters, int cursor) {
        int countOfKanjiSignificantBits = 0;
        int currentByte;
        while ((currentByte = characters[--cursor]) != ASCII_SIGNIFICANT_BYTE) {
            if (currentByte == KANJI_SIGNIFICANT_BYTE) {
                countOfKanjiSignificantBits++;
            }

        }

        return countOfKanjiSignificantBits;
    }

    private static byte[] removeCharacter(byte[] characters, int cursor, int countOfKanjiSignificantBits) {
        return countOfKanjiSignificantBits % 2 == 0 ? removeASCII(characters, cursor) : removeKANJI(characters, cursor);
    }

    private static byte[] removeASCII(byte[] characters, int cursor) {
        byte[] charactersWithBackspace = new byte[characters.length - 1];
        System.arraycopy(characters, 0, charactersWithBackspace, 0, cursor - 1);
        System.arraycopy(characters, cursor, charactersWithBackspace, cursor - 1, characters.length - cursor);
        return charactersWithBackspace;
    }

    private static byte[] removeKANJI(byte[] characters, int cursor) {
        byte[] charactersWithBackspace = new byte[characters.length - 2];
        System.arraycopy(characters, 0, charactersWithBackspace, 0, cursor - 2);
        System.arraycopy(characters, cursor, charactersWithBackspace, cursor - 2, characters.length - cursor);
        return charactersWithBackspace;

    }

    private static boolean isKanji(byte characters) {
        return characters == KANJI_SIGNIFICANT_BYTE;
    }

}
