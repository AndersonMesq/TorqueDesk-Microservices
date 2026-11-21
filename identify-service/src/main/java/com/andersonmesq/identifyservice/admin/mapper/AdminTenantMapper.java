package com.andersonmesq.identifyservice.admin.mapper;

import com.andersonmesq.identifyservice.tenant.dto.TenantResponse;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminTenantMapper {
    TenantResponse toResponse(Tenant tenant);
}