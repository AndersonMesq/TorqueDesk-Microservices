package com.andersonmesq.identifyservice.authentication.dto.response;

import java.util.List;

public record LoginResponse(
        String identityToken,
        String workspaceToken,
        List<AvailableWorkspaceResponse> workspaces
) {
}
