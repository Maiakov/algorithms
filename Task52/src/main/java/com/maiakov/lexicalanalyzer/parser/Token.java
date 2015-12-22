package com.maiakov.lexicalanalyzer.parser;

public class Token {
    public static final int END = 0;
    public static final int PLUS_MINUS = 1;
    public static final int MULT_DIV = 2;

    public static final int OPEN_BRACKET = 3;
    public static final int CLOSE_BRACKET = 4;
    public static final int NUMBER = 5;

    public final int token;
    public final String sequence;

    public Token(int token, String sequence ) {
        this.token = token;
        this.sequence = sequence;
    }
}
