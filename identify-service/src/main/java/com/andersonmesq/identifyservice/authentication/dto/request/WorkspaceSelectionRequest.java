package com.andersonmesq.identifyservice.authentication.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record WorkspaceSelectionRequest(
        @NotNull
        UUID userTenantId
) {
}
