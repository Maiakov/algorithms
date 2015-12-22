package com.maiakov.lexicalanalyzer;

import com.maiakov.lexicalanalyzer.ast.ExpressionNode;
import com.maiakov.lexicalanalyzer.parser.InputParser;

public class LexicalAnalyzer {
    public static double evaluate(String expression) {
        ExpressionNode expressionNode = new InputParser().parse(expression);
        return expressionNode.getValue();
    }
}
