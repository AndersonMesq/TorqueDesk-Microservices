package com.andersonmesq.identifyservice.admin.service;

import com.andersonmesq.identifyservice.admin.exception.DuplicateSlugException;
import com.andersonmesq.identifyservice.shared.util.SlugGenerator;
import com.andersonmesq.identifyservice.tenant.dto.TenantResponse;
import com.andersonmesq.identifyservice.tenant.dto.UpdateTenantRequest;
import com.andersonmesq.identifyservice.tenant.exception.TenantAlreadyActiveException;
import com.andersonmesq.identifyservice.tenant.exception.TenantAlreadyDeactivatedException;
import com.andersonmesq.identifyservice.tenant.exception.TenantNotFoundException;
import com.andersonmesq.identifyservice.tenant.mapper.TenantMapper;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import com.andersonmesq.identifyservice.tenant.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.andersonmesq.identifyservice.tenant.enums.TenantStatus.ACTIVE;
import static com.andersonmesq.identifyservice.tenant.enums.TenantStatus.INACTIVE;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminTenantService {
    private final TenantRepository repository;
    private final TenantMapper mapper;

    private Tenant findTenant(UUID id) {
        log.debug("Finding tenant by id {}", id);
        return repository.findById(id).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
    }

    public TenantResponse findById(UUID id) {
        Tenant tenant = findTenant(id);
        return mapper.toResponse(tenant);
    }

    public Page<TenantResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Transactional
    public TenantResponse update(UUID id, UpdateTenantRequest request){
        Tenant tenant = findTenant(id);
        tenant.setName(request.companyName());
        String newSlug = SlugGenerator.generate(request.companyName());
        if(repository.existsBySlugAndIdNot(newSlug, id)) {
            throw new DuplicateSlugException("Slug already exists");
        }
        tenant.setSlug(newSlug);
        return mapper.toResponse(tenant);
    }

    @Transactional
    public void deactivate(UUID id){
        Tenant tenant = findTenant(id);
        if(tenant.getStatus() == INACTIVE) throw new TenantAlreadyDeactivatedException("Tenant already deactivate");
        tenant.setStatus(INACTIVE);
    }

    @Transactional
    public void activate(UUID id) {
        Tenant tenant = findTenant(id);
        if(tenant.getStatus() == ACTIVE) throw new TenantAlreadyActiveException("Tenant already active");
        tenant.setStatus(ACTIVE);
    }
}