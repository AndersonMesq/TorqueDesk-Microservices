package com.andersonmesq.identifyservice.usertenant.exception;

public class UserTenantDisabledException extends RuntimeException {
    public UserTenantDisabledException(String message) {
        super(message);
    }
}
