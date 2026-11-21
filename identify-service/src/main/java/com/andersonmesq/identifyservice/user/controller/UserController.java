package com.andersonmesq.identifyservice.user.controller;

import com.andersonmesq.identifyservice.user.dto.ChangePasswordRequest;
import com.andersonmesq.identifyservice.user.dto.UpdateUserRequest;
import com.andersonmesq.identifyservice.user.dto.UserResponse;
import com.andersonmesq.identifyservice.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/me")
    public UserResponse findMe() {
        return service.findMe();
    }

    @PutMapping("/me")
    public UserResponse updateProfile(@RequestBody @Valid UpdateUserRequest request) {
        return service.updateProfile(request);
    }

    @PatchMapping("/me/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        service.changePassword(request);
    }
}