package com.andersonmesq.identifyservice.usertenant.dto;


import com.andersonmesq.identifyservice.usertenant.role.Role;

import java.util.UUID;

public record CreateUserTenantRequest(
        UUID userId,
        UUID tenantId
) {
}