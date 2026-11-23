package com.andersonmesq.identifyservice.usertenant.controller;

import com.andersonmesq.identifyservice.usertenant.dto.CreateUserTenantRequest;
import com.andersonmesq.identifyservice.usertenant.dto.UserTenantResponse;
import com.andersonmesq.identifyservice.usertenant.service.UserTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-tenants")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class UserTenantController {
    private final UserTenantService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserTenantResponse createOwner(@RequestBody CreateUserTenantRequest request){
        return service.createOwner(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserTenantResponse createAttendant(@RequestBody CreateUserTenantRequest request){
        return service.createAttendant(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserTenantResponse createMechanic(@RequestBody CreateUserTenantRequest request){
        return service.createMechanic(request);
    }
}