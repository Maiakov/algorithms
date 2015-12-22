package com.maiakov.lexicalanalyzer.parser;


import java.util.LinkedList;

import com.maiakov.lexicalanalyzer.ast.ConstantExpressionNode;
import com.maiakov.lexicalanalyzer.ast.ExpressionNode;
import com.maiakov.lexicalanalyzer.ast.actionsexpression.AdditionExpressionNode;
import com.maiakov.lexicalanalyzer.ast.actionsexpression.MultiplicationExpressionNode;
import com.maiakov.lexicalanalyzer.ast.exception.ParserException;

public class InputParser {
    private static final String PLUS = "+";
    private static final String MULTIPLY = "*";
    private static final String EMPTY_SEQUENCE = "";
    private LinkedList<Token> tokens;
    private Token lookAhead;

    public ExpressionNode parse(String expression) {
        Tokenizer tokenizer = Tokenizer.getExpressionTokenizer();
        tokenizer.tokenize(expression);
        LinkedList<Token> tokens = tokenizer.getTokens();
        return this.parse(tokens);
    }

    public ExpressionNode parse(LinkedList<Token> tokens) {
        this.tokens = (LinkedList<Token>) tokens.clone();
        lookAhead = this.tokens.getFirst();

        ExpressionNode expr = expression();

        if (lookAhead.token != Token.END) {
            throw new ParserException(String.format("Unexpected symbol %s found", lookAhead));
        }
        return expr;
    }

    private void nextToken() {
        tokens.pop();
        if (tokens.isEmpty()) {
            lookAhead = new Token(Token.END, EMPTY_SEQUENCE);
        } else {
            lookAhead = tokens.getFirst();
        }
    }


    private ExpressionNode sumOperation(ExpressionNode expr) {
        if (lookAhead.token == Token.PLUS_MINUS) {
            AdditionExpressionNode sum;
            if (expr.getType() == ExpressionNode.ADDITION_NODE) {
                sum = (AdditionExpressionNode) expr;
            } else {
                sum = new AdditionExpressionNode(expr, true);
            }
            boolean positive = lookAhead.sequence.equals(PLUS);
            nextToken();
            ExpressionNode t = term();
            sum.add(t, positive);

            return sumOperation(sum);
        }

        return expr;
    }

    private ExpressionNode signedTerm() {
        if (lookAhead.token == Token.PLUS_MINUS) {
            boolean positive = lookAhead.sequence.equals(PLUS);
            nextToken();
            ExpressionNode t = term();
            if (positive) {
                return t;
            } else {
                return new AdditionExpressionNode(t, false);
            }
        }
        return term();
    }

    private ExpressionNode term() {
        ExpressionNode f = coefficient();
        return termOperation(f);
    }

    private ExpressionNode termOperation(ExpressionNode expression) {
        if (lookAhead.token == Token.MULT_DIV) {
            MultiplicationExpressionNode production;

            if (expression.getType() == ExpressionNode.MULTIPLICATION_NODE) {
                production = (MultiplicationExpressionNode) expression;
            } else {
                production = new MultiplicationExpressionNode(expression, true);
            }
            boolean positive = lookAhead.sequence.equals(MULTIPLY);
            nextToken();
            ExpressionNode f = signedFactor();
            production.add(f, positive);

            return termOperation(production);
        }
        return expression;
    }


    private ExpressionNode argument() {

        if (lookAhead.token == Token.OPEN_BRACKET) {
            nextToken();
            ExpressionNode expr = expression();
            if (lookAhead.token != Token.CLOSE_BRACKET) {
                throw new ParserException(String.format("Closing brackets expected", lookAhead));
            }
            nextToken();
            return expr;
        }

        return value();
    }

    private ExpressionNode value() {
        if (lookAhead.token == Token.NUMBER) {
            ExpressionNode expr = new ConstantExpressionNode(lookAhead.sequence);
            nextToken();
            return expr;
        }

        if (lookAhead.token == Token.END) {
            throw new ParserException("Unexpected end of input");
        } else {
            throw new ParserException(String.format("Unexpected symbol %s found", lookAhead));
        }
    }

    private ExpressionNode coefficient() {
        ExpressionNode a = argument();
        return factorOperation(a);
    }

    private ExpressionNode signedFactor() {
        if (lookAhead.token == Token.PLUS_MINUS) {
            boolean positive = lookAhead.sequence.equals("+");
            nextToken();
            ExpressionNode t = coefficient();
            if (positive) {
                return t;
            } else {
                return new AdditionExpressionNode(t, false);
            }
        }
        return coefficient();
    }

    private ExpressionNode expression() {
        ExpressionNode expr = signedTerm();
        return sumOperation(expr);
    }

    private ExpressionNode factorOperation(ExpressionNode expression) {
        return expression;
    }
}
