package com.zoho.customexception;

public class StringTaskException extends CustomException {
    public StringTaskException(String errorMessage) {
        super(errorMessage);
    }

    public StringTaskException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

