package com.andersonmesq.identifyservice.authentication.dto.response;

public record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {
}
