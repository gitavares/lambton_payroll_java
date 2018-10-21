package com.finalproject.group01.exceptions;

public class InvalidFieldException extends Exception {
    private int errorCode;
    private String errorMessage;

    public InvalidFieldException() {
        this.errorCode = -2000;
        this.errorMessage = InvalidFieldException.class.getCanonicalName() + " - Field can not be null";
    }

    public InvalidFieldException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
