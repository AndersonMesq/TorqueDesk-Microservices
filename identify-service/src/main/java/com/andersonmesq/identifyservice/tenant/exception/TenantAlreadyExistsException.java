package com.andersonmesq.identifyservice.tenant.exception;

public class TenantAlreadyExistsException extends RuntimeException {
    public TenantAlreadyExistsException(String message) {
        super("Empresa ja cadastrada " + message);
    }
}
