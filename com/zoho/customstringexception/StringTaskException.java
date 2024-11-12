package com.zoho.customstringexception;

public class StringTaskException extends CustomStringException {
    public StringTaskException(String errorMessage) {
        super(errorMessage);
    }

    public StringTaskException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

