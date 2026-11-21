package com.andersonmesq.identifyservice.usertenant.dto;


import com.andersonmesq.identifyservice.usertenant.role.Role;

import java.util.UUID;

public record UserTenantResponse(
        UUID id,
        UUID userId,
        UUID tenantId,
        Role role,
        Boolean enabled
) {
}
