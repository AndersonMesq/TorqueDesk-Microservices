package com.andersonmesq.identifyservice.usertenant.exception;

public class TenantInactiveException extends RuntimeException {
    public TenantInactiveException(String message) {
        super(message);
    }
}
