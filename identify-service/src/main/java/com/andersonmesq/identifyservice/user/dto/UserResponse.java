package com.andersonmesq.identifyservice.user.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String fullName,
        String userName,
        Boolean enabled
) {
}