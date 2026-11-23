package com.andersonmesq.service_order_service.service_order.exception;

public class ServiceOrderAssignmentAlreadyStartedException extends RuntimeException {
    public ServiceOrderAssignmentAlreadyStartedException(String message) {
        super(message);
    }
}
