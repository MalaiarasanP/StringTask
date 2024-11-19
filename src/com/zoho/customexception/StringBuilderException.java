package com.zoho.customexception;

public class StringBuilderException extends CustomException {
    public StringBuilderException(String errorMessage) {
        super(errorMessage);
    }

    public StringBuilderException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

