package com.andersonmesq.identifyservice.authentication.dto.response;

import com.andersonmesq.identifyservice.usertenant.role.Role;

import java.util.UUID;

public record AvailableWorkspaceResponse(
        UUID userTenantId,
        UUID tenantId,
        String tenantName,
        Role role
) {
}
