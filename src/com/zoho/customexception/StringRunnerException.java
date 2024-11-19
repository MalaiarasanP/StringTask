package com.zoho.customexception;
public class StringRunnerException extends CustomException {
    public StringRunnerException(String errorMessage) {
        super(errorMessage);
    }

    public StringRunnerException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

