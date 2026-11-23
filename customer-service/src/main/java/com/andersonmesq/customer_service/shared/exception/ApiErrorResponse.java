package com.andersonmesq.customer_service.shared.exception;

public record ApiErrorResponse(
        int status,
        String error,
        String message
) {
}
