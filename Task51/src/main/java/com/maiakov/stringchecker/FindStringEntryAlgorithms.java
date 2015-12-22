package com.maiakov.stringchecker;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings S1 and S2. Delete from S2 all those characters which occur in S1 also and finally
 * create a clean S2 with the relevant characters deleted.
 */
public class FindStringEntryAlgorithms {

    public static String getDeletedCharacters(String s1, String s2) {
        if(s1 == null || s2 == null){
            throw new IllegalArgumentException("Input string can not be null");
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            uniqueChars.add(c);
        }
        StringBuilder deletedCharacters = new StringBuilder();
        for (char c : s2.toCharArray()) {
            if (uniqueChars.contains(c)) {
                deletedCharacters.append(c);
            }
            ;
        }
        return deletedCharacters.toString();
    }
}
