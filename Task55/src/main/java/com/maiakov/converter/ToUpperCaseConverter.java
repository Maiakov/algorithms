package com.maiakov.converter;

public class ToUpperCaseConverter {

    private static final int HIGH_BOUND_OF_LOWERCASE_ROMAN = 122;
    private static final int LOWER_BOUND_OF_LOWERCASE_ROMAN = 97;
    private static final int HIGH_BOUND_OF_LOWERCASE_CYRILLIC = 1104;
    private static final int LOWER_BOUND_OF_LOWERCASE_CYRILLIC = 1072;
    private static final int DIFFERENCE_BETWEEN_HIGH_AND_LOW_LETTERS = 32;

    public static char[] convertToUpperCase(char[] characters) {
        if (characters == null) {
            throw new IllegalArgumentException("Characters array can not be empty");
        }
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            if (isRomanInLowerCase(character)) {
                characters[i] = (char) (character ^ DIFFERENCE_BETWEEN_HIGH_AND_LOW_LETTERS);
            }
            else if(isCyrillicInLowerCase(character)){
                characters[i]  = (char) (character - DIFFERENCE_BETWEEN_HIGH_AND_LOW_LETTERS);
            }
        }
        return characters;
    }

    private static boolean isCyrillicInLowerCase(char character) {
        return character >= LOWER_BOUND_OF_LOWERCASE_CYRILLIC && character <= HIGH_BOUND_OF_LOWERCASE_CYRILLIC;
    }

    private static boolean isRomanInLowerCase(char character) {
        return character >= LOWER_BOUND_OF_LOWERCASE_ROMAN && character <= HIGH_BOUND_OF_LOWERCASE_ROMAN;
    }
}
