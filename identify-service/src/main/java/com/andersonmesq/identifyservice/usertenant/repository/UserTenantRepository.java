package com.andersonmesq.identifyservice.usertenant.repository;

import com.andersonmesq.identifyservice.usertenant.model.UserTenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserTenantRepository extends JpaRepository<UserTenant, UUID> {
        List<UserTenant> findAllByTenantId(UUID tenantId);
        List<UserTenant> findAllByUserId(UUID userId);
        Optional<UserTenant> findByUserIdAndTenantId(UUID userId, UUID tenantId);
        boolean existsByUserIdAndTenantId(UUID userId, UUID tenantId);
}