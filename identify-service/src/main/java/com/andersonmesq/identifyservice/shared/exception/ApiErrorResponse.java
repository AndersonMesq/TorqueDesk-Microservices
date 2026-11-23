package com.andersonmesq.identifyservice.shared.exception;

public record ApiErrorResponse(
        int status,
        String error,
        String message
) {
}
