package com.maiakov.treebuilder.exception;

public class FileParserException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Input data file incorrect.";
    }
}
