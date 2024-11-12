package com.zoho.customstringexception;

public class StringUtilityException extends CustomStringException {
    public StringUtilityException(String errorMessage) {
        super(errorMessage);
    }

    public StringUtilityException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

