package com.andersonmesq.identifyservice.usertenant.service;

import com.andersonmesq.identifyservice.tenant.enums.TenantStatus;
import com.andersonmesq.identifyservice.tenant.exception.TenantNotFoundException;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import com.andersonmesq.identifyservice.tenant.repository.TenantRepository;
import com.andersonmesq.identifyservice.user.exception.UserNotFoundException;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.user.repository.UserRepository;
import com.andersonmesq.identifyservice.usertenant.dto.CreateUserTenantRequest;
import com.andersonmesq.identifyservice.usertenant.dto.UserTenantResponse;
import com.andersonmesq.identifyservice.usertenant.exception.TenantInactiveException;
import com.andersonmesq.identifyservice.usertenant.exception.UserTenantAlreadyExistException;
import com.andersonmesq.identifyservice.usertenant.mapper.UserTenantMapper;
import com.andersonmesq.identifyservice.usertenant.model.UserTenant;
import com.andersonmesq.identifyservice.usertenant.repository.UserTenantRepository;
import com.andersonmesq.identifyservice.usertenant.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserTenantService {
    private final UserTenantRepository repository;
    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final UserTenantMapper mapper;

    public UserTenantResponse createOwner(CreateUserTenantRequest request){
        return createUserTenant(request, Role.OWNER);
    }

    public UserTenantResponse createAttendant(CreateUserTenantRequest request){
        return createUserTenant(request, Role.ATTENDANT);
    }

    public UserTenantResponse createMechanic(CreateUserTenantRequest request){
        return createUserTenant(request, Role.MECHANIC);
    }

    private UserTenantResponse createUserTenant(CreateUserTenantRequest request, Role role){
        UserTenantContext context = userTenantSearchAndFilter(request);
        UserTenant userTenant = UserTenant.builder()
                .user(context.user())
                .tenant(context.tenant())
                .role(role)
                .enabled(true)
                .build();
        repository.save(userTenant);

        return mapper.toResponse(userTenant);
    }

    private UserTenantContext userTenantSearchAndFilter(CreateUserTenantRequest request){
        if(repository.existsByUserIdAndTenantId(request.userId(), request.tenantId())) throw new UserTenantAlreadyExistException("User already linked to tenant");
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Tenant tenant = tenantRepository.findById(request.tenantId()).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        if (tenant.getStatus() != TenantStatus.ACTIVE) throw new TenantInactiveException("Cannot link user to an inactive tenant");

        return new UserTenantContext(user, tenant);
    }

    private record UserTenantContext(User user, Tenant tenant) {}
}
