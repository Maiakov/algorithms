package com.maiakov.lexicalanalyzer.ast.actionsexpression;

import com.maiakov.lexicalanalyzer.ast.ExpressionNode;
import com.maiakov.lexicalanalyzer.ast.SequenceExpressionNode;
import com.maiakov.lexicalanalyzer.ast.Term;

public class AdditionExpressionNode extends SequenceExpressionNode {

    public AdditionExpressionNode(ExpressionNode a, boolean positive) {
        super(a, positive);
    }

    public int getType() {
        return ExpressionNode.ADDITION_NODE;
    }

    public double getValue() {
        double result = 0.0;
        for (Term t : terms) {
            if (t.positive) {
                result += t.expression.getValue();
            } else {
                result -= t.expression.getValue();
            }
        }
        return result;
    }
}