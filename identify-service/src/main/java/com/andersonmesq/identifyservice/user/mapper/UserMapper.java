package com.andersonmesq.identifyservice.user.mapper;

import com.andersonmesq.identifyservice.user.dto.UserResponse;
import com.andersonmesq.identifyservice.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
}