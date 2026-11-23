package com.andersonmesq.identifyservice.user.exception;

public class SamePasswordException extends RuntimeException {
    public SamePasswordException(String message) {
        super(message);
    }
}
