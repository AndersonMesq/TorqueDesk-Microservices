package com.andersonmesq.identifyservice.admin.service;

import com.andersonmesq.identifyservice.admin.dto.TenantProvisionResponse;
import com.andersonmesq.identifyservice.admin.exception.DuplicateSlugException;
import com.andersonmesq.identifyservice.shared.util.PasswordGenerator;
import com.andersonmesq.identifyservice.shared.util.SlugGenerator;
import com.andersonmesq.identifyservice.tenant.dto.CreateTenantRequest;
import com.andersonmesq.identifyservice.tenant.enums.TenantStatus;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import com.andersonmesq.identifyservice.tenant.repository.TenantRepository;
import com.andersonmesq.identifyservice.user.exception.OwnerAlreadyExistException;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.user.repository.UserRepository;
import com.andersonmesq.identifyservice.user.systemrole.SystemRole;
import com.andersonmesq.identifyservice.usertenant.model.UserTenant;
import com.andersonmesq.identifyservice.usertenant.repository.UserTenantRepository;
import com.andersonmesq.identifyservice.usertenant.role.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TenantProvisioningService {
    private final TenantRepository tenantRepository;
    private final UserRepository userRepository;
    private final UserTenantRepository userTenantRepository;
    private final PasswordEncoder passwordEncoder;

    public TenantProvisionResponse createTenant(@Valid CreateTenantRequest request) {
        String slug = SlugGenerator.generate(request.companyName());
        if (tenantRepository.existsBySlug(slug)) {
            throw new DuplicateSlugException("Tenant already exists");
        }
        if (userRepository.existsByEmail(request.ownerEmail().toLowerCase())) {
            throw new OwnerAlreadyExistException("Owner with this email already exists");
        }
        Tenant tenant = Tenant.builder()
                .name(request.companyName())
                .slug(slug)
                .status(TenantStatus.ACTIVE)
                .build();
        tenantRepository.save(tenant);
        log.debug("Tenant save called");

        String temporaryPassword = PasswordGenerator.generate();
        User owner = User.builder()
                .fullName(request.ownerName())
                .email(request.ownerEmail().toLowerCase())
                .password(passwordEncoder.encode(temporaryPassword))
                .systemRole(SystemRole.USER)
                .enabled(true)
                .build();
        userRepository.save(owner);
        log.debug("User save called");

        UserTenant userTenant = UserTenant.builder()
                .user(owner)
                .tenant(tenant)
                .role(Role.OWNER)
                .enabled(true)
                .build();
        userTenantRepository.save(userTenant);
        log.debug("UserTenant save called");

        return new TenantProvisionResponse(tenant.getId(), owner.getId(), temporaryPassword);
    }
}