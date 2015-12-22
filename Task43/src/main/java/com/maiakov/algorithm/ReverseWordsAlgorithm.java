package com.maiakov.algorithm;


public class ReverseWordsAlgorithm {

    public static final char SPACE = ' ';

    public static char[] reverseWords(char[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        reverseCharsArray(words, 0, words.length);
        int startIndexOfWord = 0;
        startIndexOfWord = reverseWordByWord(words, startIndexOfWord);
        reverseLastWord(words, startIndexOfWord);
        return words;
    }

    static void reverseCharsArray(char[] words, int startIndex, int endIndex) {
        startIndex = skipSpaces(words, startIndex);
        for (int i = startIndex; i < (startIndex + endIndex) / 2; i++) {
            swapChars(words, i, startIndex + endIndex - 1 - i);
        }
    }

    static int skipSpaces(char[] words, int index) {
        for (int i = index; i < words.length; i++) {
            if (words[i] != SPACE) {
                return i;
            }
        }
        return words.length - 1;
    }

    private static int reverseWordByWord(char[] words, int startIndexOfWord) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] == SPACE) {
                reverseCharsArray(words, startIndexOfWord, i);
                i = skipSpaces(words, i);
                startIndexOfWord = i;
            }
        }
        return startIndexOfWord;
    }

    private static void swapChars(char[] words, int index1, int index2) {
        char temp = words[index1];
        words[index1] = words[index2];
        words[index2] = temp;
    }

    private static void reverseLastWord(char[] words, int startIndexOfWord) {
        reverseCharsArray(words, startIndexOfWord, words.length);
    }
}
