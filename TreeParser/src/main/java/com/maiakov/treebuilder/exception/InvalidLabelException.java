package com.maiakov.treebuilder.exception;

public class InvalidLabelException extends RuntimeException {
    private String message;

    public InvalidLabelException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Incorrect label found: " + message + " Label must be combination of uppercase and lowercase English letters.";
    }
}
