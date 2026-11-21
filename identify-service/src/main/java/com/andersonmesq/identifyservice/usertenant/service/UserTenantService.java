package com.andersonmesq.identifyservice.usertenant.service;

import com.andersonmesq.identifyservice.tenant.exception.TenantNotFoundException;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import com.andersonmesq.identifyservice.tenant.repository.TenantRepository;
import com.andersonmesq.identifyservice.user.exception.UserNotFoundException;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.user.repository.UserRepository;
import com.andersonmesq.identifyservice.usertenant.dto.CreateUserTenantRequest;
import com.andersonmesq.identifyservice.usertenant.dto.UserTenantResponse;
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

    public UserTenantResponse create(CreateUserTenantRequest request){
        if(repository.existsByUserIdAndTenantId(request.userId(), request.tenantId())) throw new UserTenantAlreadyExistException("User already linked to tenant");
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Tenant tenant = tenantRepository.findById(request.tenantId()).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        UserTenant userTenant = UserTenant.builder()
                .user(user)
                .tenant(tenant)
                .role(request.role())
                .enabled(true)
                .build();
        repository.save(userTenant);

        return mapper.toResponse(userTenant);
    }

    public UserTenantResponse createOwner(CreateUserTenantRequest request){
        if(repository.existsByUserIdAndTenantId(request.userId(), request.tenantId())) throw new UserTenantAlreadyExistException("User already linked to tenant");
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Tenant tenant = tenantRepository.findById(request.tenantId()).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        UserTenant userTenant = UserTenant.builder()
                .user(user)
                .tenant(tenant)
                .role(Role.OWNER)
                .enabled(true)
                .build();
        repository.save(userTenant);

        return mapper.toResponse(userTenant);
    }

    public UserTenantResponse createAttendant(CreateUserTenantRequest request){
        if(repository.existsByUserIdAndTenantId(request.userId(), request.tenantId())) throw new UserTenantAlreadyExistException("User already linked to tenant");
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Tenant tenant = tenantRepository.findById(request.tenantId()).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        UserTenant userTenant = UserTenant.builder()
                .user(user)
                .tenant(tenant)
                .role(Role.ATTENDANT)
                .enabled(true)
                .build();
        repository.save(userTenant);

        return mapper.toResponse(userTenant);
    }

    public UserTenantResponse createMechanic(CreateUserTenantRequest request){
        if(repository.existsByUserIdAndTenantId(request.userId(), request.tenantId())) throw new UserTenantAlreadyExistException("User already linked to tenant");
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Tenant tenant = tenantRepository.findById(request.tenantId()).orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        UserTenant userTenant = UserTenant.builder()
                .user(user)
                .tenant(tenant)
                .role(Role.MECHANIC)
                .enabled(true)
                .build();
        repository.save(userTenant);

        return mapper.toResponse(userTenant);
    }
}
