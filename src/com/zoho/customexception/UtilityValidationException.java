package com.zoho.customexception;

public class UtilityValidationException extends CustomException {
    public UtilityValidationException(String errorMessage) {
        super(errorMessage);
    }

    public UtilityValidationException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}

