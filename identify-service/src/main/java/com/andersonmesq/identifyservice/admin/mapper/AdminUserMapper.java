package com.andersonmesq.identifyservice.admin.mapper;

import com.andersonmesq.identifyservice.user.dto.UserResponse;
import com.andersonmesq.identifyservice.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {
    UserResponse toResponse(User user);
}