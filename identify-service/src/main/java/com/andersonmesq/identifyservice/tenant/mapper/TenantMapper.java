package com.andersonmesq.identifyservice.tenant.mapper;

import com.andersonmesq.identifyservice.tenant.dto.TenantResponse;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    TenantResponse toResponse(
            Tenant tenant
    );
}