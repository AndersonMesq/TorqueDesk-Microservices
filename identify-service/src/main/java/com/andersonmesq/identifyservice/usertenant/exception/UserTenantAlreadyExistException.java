package com.andersonmesq.identifyservice.usertenant.exception;

public class UserTenantAlreadyExistException extends RuntimeException {
    public UserTenantAlreadyExistException(String message) {
        super(message);
    }
}
