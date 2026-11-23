package com.andersonmesq.identifyservice.admin.controller;

import com.andersonmesq.identifyservice.admin.dto.TenantProvisionResponse;
import com.andersonmesq.identifyservice.admin.service.AdminTenantService;
import com.andersonmesq.identifyservice.admin.service.TenantProvisioningService;
import com.andersonmesq.identifyservice.tenant.dto.CreateTenantRequest;
import com.andersonmesq.identifyservice.tenant.dto.TenantResponse;
import com.andersonmesq.identifyservice.tenant.dto.UpdateTenantRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@Tag(name = "Admin Tenant Endpoint")
@RequestMapping("/api/v1/admin/tenants")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class AdminTenantController {
    private final TenantProvisioningService provisioningService;
    private final AdminTenantService tenantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TenantProvisionResponse create(@RequestBody @Valid CreateTenantRequest request) {
        log.debug("Tenant creation request: {}", request.companyName());
        return provisioningService.createTenant(request);
    }

    @GetMapping("/{id}")
    public TenantResponse findById(@PathVariable UUID id) {
        return tenantService.findById(id);
    }

    @GetMapping
    public Page<TenantResponse> findAll(@PageableDefault(sort = "name",direction = Sort.Direction.ASC, size = 20) Pageable pageable) {
        return tenantService.findAll(pageable);
    }

    @PatchMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(@PathVariable UUID id) {
        tenantService.deactivate(id);
    }

    @PatchMapping("/{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activate(@PathVariable UUID id) {
        tenantService.activate(id);
    }

    @PutMapping("/{id}")
    public TenantResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateTenantRequest request) {
        return tenantService.update(id, request);
    }
}