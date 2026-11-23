package com.andersonmesq.service_order_service.shared.exception;

public record ApiErrorResponse(
        int status,
        String error,
        String message
) {
}
