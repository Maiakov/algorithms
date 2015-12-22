package com.maiakov.treebuilder.exception;

public class EmptyFileException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Input data file can not be empty.";
    }
}
