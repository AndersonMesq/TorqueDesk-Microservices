package com.andersonmesq.identifyservice.user.exception;

public class OwnerAlreadyExistException extends RuntimeException {
    public OwnerAlreadyExistException(String message) {
        super(message);
    }
}
