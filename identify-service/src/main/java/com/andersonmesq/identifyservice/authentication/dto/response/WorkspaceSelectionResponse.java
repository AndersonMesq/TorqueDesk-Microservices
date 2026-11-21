package com.andersonmesq.identifyservice.authentication.dto.response;

import com.andersonmesq.identifyservice.usertenant.role.Role;

import java.util.UUID;

public record WorkspaceSelectionResponse(
        String workspaceToken,
        UUID tenantId,
        String tenantName,
        Role role
) {
}
