package com.andersonmesq.identifyservice.tenant.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateTenantRequest(
        @NotBlank
        String companyName
) {
}