package com.andersonmesq.identifyservice.authentication.mapper;

import com.andersonmesq.identifyservice.authentication.dto.response.AvailableWorkspaceResponse;
import com.andersonmesq.identifyservice.usertenant.model.UserTenant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailableWorkspaceMapper {
    AvailableWorkspaceResponse toResponse(UserTenant userTenant);
}
