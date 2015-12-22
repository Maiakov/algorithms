package com.maiakov.lexicalanalyzer.ast;


public class Term {
    public boolean positive;
    public ExpressionNode expression;

    public Term(boolean positive, ExpressionNode expression) {
        this.positive = positive;
        this.expression = expression;
    }
}