package com.maiakov.lexicalanalyzer.ast.actionsexpression;

import com.maiakov.lexicalanalyzer.ast.ExpressionNode;
import com.maiakov.lexicalanalyzer.ast.SequenceExpressionNode;
import com.maiakov.lexicalanalyzer.ast.Term;

public class MultiplicationExpressionNode extends SequenceExpressionNode {

    public MultiplicationExpressionNode(ExpressionNode a, boolean positive) {
        super(a, positive);
    }

    public int getType() {
        return ExpressionNode.MULTIPLICATION_NODE;
    }

    public double getValue() {
        double result = 1.0;
        for (Term t : terms) {
            if (t.positive) {
                result *= t.expression.getValue();
            } else {
                result /= t.expression.getValue();
            }
        }
        return result;
    }
}