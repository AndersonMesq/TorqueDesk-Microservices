package com.andersonmesq.identifyservice.shared.exception;

import com.andersonmesq.identifyservice.admin.exception.DuplicateSlugException;
import com.andersonmesq.identifyservice.admin.exception.UserCreationNotAllowedException;
import com.andersonmesq.identifyservice.admin.exception.UserEmailAlreadyExistException;
import com.andersonmesq.identifyservice.admin.exception.UserNameAlreadyExistException;
import com.andersonmesq.identifyservice.security.exception.InvalidTokenException;
import com.andersonmesq.identifyservice.security.exception.UnauthorizedException;
import com.andersonmesq.identifyservice.tenant.exception.*;
import com.andersonmesq.identifyservice.user.exception.*;
import com.andersonmesq.identifyservice.usertenant.exception.UserTenantAlreadyExistException;
import com.andersonmesq.identifyservice.usertenant.exception.UserTenantDisabledException;
import com.andersonmesq.identifyservice.usertenant.exception.UserTenantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleAdminUserAlreadyExistsException(
            UserAlreadyExistsException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(DuplicateSlugException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateSlugException(DuplicateSlugException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserCreationNotAllowedException.class)
    public ResponseEntity<ApiErrorResponse> handleUserCreationNotAllowedException(UserCreationNotAllowedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(UserEmailAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleUserEmailAlreadyExistException(UserEmailAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserNameAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNameAlreadyExistException(UserNameAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidTokenException(InvalidTokenException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiErrorResponse> handleUnauthorizedException(UnauthorizedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(TenantAlreadyActiveException.class)
    public ResponseEntity<ApiErrorResponse> handleTenantAlreadyActiveException(TenantAlreadyActiveException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(TenantAlreadyDeactivatedException.class)
    public ResponseEntity<ApiErrorResponse> handleTenantAlreadyDeactivatedException(
            TenantAlreadyDeactivatedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(TenantAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleTenantAlreadyExistsException(TenantAlreadyExistsException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(TenantNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleTenantNotFoundException(TenantNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(SamePasswordException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidPasswordException(SamePasswordException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(OwnerAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleOwnerAlreadyExistException(OwnerAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserAlreadyActiveException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyActiveException(UserAlreadyActiveException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserAlreadyDeactivatedException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyDeactivatedException(UserAlreadyDeactivatedException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExistsException(
            UserAlreadyExistsException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UserTenantAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleUserTenantAlreadyExistException(UserTenantAlreadyExistException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UserTenantDisabledException.class)
    public ResponseEntity<ApiErrorResponse> handleUserTenantDisabledException(UserTenantDisabledException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(UserTenantNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserTenantNotFoundException(UserTenantNotFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}