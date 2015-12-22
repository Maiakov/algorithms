package com.maiakov.treebuilder.exception;

public class TreeBuilderException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Input data can not be represented as Tree.";
    }
}
