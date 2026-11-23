package com.andersonmesq.customer_service.shared.exception;

import com.andersonmesq.customer_service.customer.exception.CustomerAlreadyExistException;
import com.andersonmesq.customer_service.customer.exception.CustomerNotFoundException;
import com.andersonmesq.customer_service.vehicle.exception.VehicleAlreadyExistException;
import com.andersonmesq.customer_service.vehicle.exception.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomerAlreadyExistException(CustomerAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(VehicleAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleVehicleAlreadyExistException(VehicleAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleVehicleNotFoundException(
            VehicleNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleServiceOrderVehicleNotFoundException(
            VehicleNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}