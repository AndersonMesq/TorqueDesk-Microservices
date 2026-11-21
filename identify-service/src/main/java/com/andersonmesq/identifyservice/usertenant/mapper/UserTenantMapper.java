package com.andersonmesq.identifyservice.usertenant.mapper;

import com.andersonmesq.identifyservice.usertenant.dto.UserTenantResponse;
import com.andersonmesq.identifyservice.usertenant.model.UserTenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserTenantMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "tenant.id", target = "tenantId")
    UserTenantResponse toResponse(UserTenant userTenant);
}