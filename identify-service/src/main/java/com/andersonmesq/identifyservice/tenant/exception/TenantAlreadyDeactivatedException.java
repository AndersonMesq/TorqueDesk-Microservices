package com.andersonmesq.identifyservice.tenant.exception;

public class TenantAlreadyDeactivatedException extends RuntimeException {
    public TenantAlreadyDeactivatedException(String message) {
        super(message);
    }
}
