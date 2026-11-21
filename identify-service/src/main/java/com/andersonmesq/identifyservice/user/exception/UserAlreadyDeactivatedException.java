package com.andersonmesq.identifyservice.user.exception;

public class UserAlreadyDeactivatedException extends RuntimeException {
    public UserAlreadyDeactivatedException(String message) {
        super(message);
    }
}
