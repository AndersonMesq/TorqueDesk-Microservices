package com.andersonmesq.identifyservice.usertenant.exception;

public class UserTenantNotFoundException extends RuntimeException {
    public UserTenantNotFoundException(String message) {
        super(message);
    }
}
