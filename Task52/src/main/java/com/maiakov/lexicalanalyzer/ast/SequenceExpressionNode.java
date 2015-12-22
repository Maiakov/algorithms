package com.maiakov.lexicalanalyzer.ast;

import java.util.LinkedList;

public abstract class SequenceExpressionNode implements ExpressionNode {

    protected LinkedList<Term> terms;

    public SequenceExpressionNode(ExpressionNode a, boolean positive) {
        this.terms = new LinkedList<>();
        this.terms.add(new Term(positive, a));
    }

    public void add(ExpressionNode a, boolean positive) {
        this.terms.add(new Term(positive, a));
    }
}