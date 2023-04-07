package com.tyba.challenge.exceptions;

public class TokenValueException extends AssertionError{

    public TokenValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
