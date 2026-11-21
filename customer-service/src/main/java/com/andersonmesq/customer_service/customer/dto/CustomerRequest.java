package com.andersonmesq.customer_service.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(
        @NotBlank
        @Email
        String email
) {
}
