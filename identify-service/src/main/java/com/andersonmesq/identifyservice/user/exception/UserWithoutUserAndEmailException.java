package com.andersonmesq.identifyservice.user.exception;

public class UserWithoutUserAndEmailException extends RuntimeException {
    public UserWithoutUserAndEmailException(String message) {
        super(message);
    }
}
