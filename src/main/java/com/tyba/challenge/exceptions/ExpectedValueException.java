package com.tyba.challenge.exceptions;

public class ExpectedValueException extends AssertionError{

    public ExpectedValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
