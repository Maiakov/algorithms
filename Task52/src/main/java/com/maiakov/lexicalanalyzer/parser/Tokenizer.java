package com.maiakov.lexicalanalyzer.parser;

import com.maiakov.lexicalanalyzer.ast.exception.ParserException;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private class TokenInfo {
        public final Pattern regex;
        public final int token;
        public TokenInfo(Pattern regex, int token) {
            this.regex = regex;
            this.token = token;
        }
    }

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;
    private static Tokenizer expressionTokenizer = null;

    public Tokenizer() {
        tokenInfos = new LinkedList<>();
        tokens = new LinkedList<>();
    }

    public static Tokenizer getExpressionTokenizer() {
        if (expressionTokenizer == null) {
            expressionTokenizer = createExpressionTokenizer();
        }
        return expressionTokenizer;
    }

    private static Tokenizer createExpressionTokenizer() {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("[+-]", Token.PLUS_MINUS);
        tokenizer.add("[*/]", Token.MULT_DIV);
        tokenizer.add("\\(", Token.OPEN_BRACKET);
        tokenizer.add("\\)", Token.CLOSE_BRACKET);
        tokenizer.add("\\d+(\\.\\d+)?",Token.NUMBER);
        return tokenizer;
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^" + regex), token));
    }

    public void tokenize(String str) {
        String s = str.trim();
        tokens.clear();
        while (!s.equals("")) {
            boolean match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    s = m.replaceFirst("").trim();
                    tokens.add(new Token(info.token, tok));
                    break;

                }
            }
            if (!match) {
                throw new ParserException("Unexpected character in input: " + s);
            }
        }
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }
}
