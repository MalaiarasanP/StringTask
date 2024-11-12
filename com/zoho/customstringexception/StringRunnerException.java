package com.zoho.customstringexception;
public class StringRunnerException extends CustomStringException {
    public StringRunnerException(String errorMessage) {
        super(errorMessage);
    }

    public StringRunnerException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

