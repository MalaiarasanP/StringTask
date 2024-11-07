package com.zoho.customexception.customstringexception;
public class CustomStringException extends Exception {
    public CustomStringException(String errorMessage) {
        super(errorMessage);
    }
    public CustomStringException(String errorMessage,Throwable cause) {
        super(errorMessage, cause);
    }
}
