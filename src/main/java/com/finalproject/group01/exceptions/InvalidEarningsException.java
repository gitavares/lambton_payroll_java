package com.finalproject.group01.exceptions;

public class InvalidEarningsException extends Exception {
    private int errorCode;
    private String errorMessage;

    public InvalidEarningsException() {
        this.errorCode = -1000;
        this.errorMessage = InvalidEarningsException.class.getCanonicalName() + " - Invalid Earnings";
    }

    public InvalidEarningsException(String errorMessage) {
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
