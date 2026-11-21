package com.andersonmesq.identifyservice.tenant.dto;


import com.andersonmesq.identifyservice.tenant.enums.TenantStatus;

import java.util.UUID;

public record TenantResponse(
        UUID id,
        String name,
        String slug,
        TenantStatus status
) {
}
