package com.andersonmesq.customer_service.vehicle.exception;

public class VehicleAlreadyExistException extends RuntimeException {
    public VehicleAlreadyExistException(String message) {
        super(message);
    }
}
