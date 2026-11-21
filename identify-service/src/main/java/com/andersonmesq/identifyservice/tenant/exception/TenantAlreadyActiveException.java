package com.andersonmesq.identifyservice.tenant.exception;

public class TenantAlreadyActiveException extends RuntimeException {
    public TenantAlreadyActiveException(String message) {
        super(message);
    }
}
