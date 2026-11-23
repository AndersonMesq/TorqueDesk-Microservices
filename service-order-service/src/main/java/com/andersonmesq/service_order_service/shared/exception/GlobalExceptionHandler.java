package com.andersonmesq.service_order_service.shared.exception;

import com.andersonmesq.service_order_service.service_order.exception.ServiceOrderAssignmentAlreadyFinishedException;
import com.andersonmesq.service_order_service.service_order.exception.ServiceOrderAssignmentAlreadyStartedException;
import com.andersonmesq.service_order_service.service_order.exception.ServiceOrderNotFoundException;
import com.andersonmesq.service_order_service.service_order.exception.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceOrderAssignmentAlreadyFinishedException.class)
    public ResponseEntity<ApiErrorResponse> handleServiceOrderAssignmentAlreadyFinishedException(
            ServiceOrderAssignmentAlreadyFinishedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ServiceOrderAssignmentAlreadyStartedException.class)
    public ResponseEntity<ApiErrorResponse> handleServiceOrderAssignmentAlreadyStartedException(
            ServiceOrderAssignmentAlreadyStartedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ServiceOrderNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleServiceOrderNotFoundException(ServiceOrderNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleVehicleNotFoundException(VehicleNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}