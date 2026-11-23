package com.andersonmesq.identifyservice.user.service;

import com.andersonmesq.identifyservice.security.context.SecurityUtils;
import com.andersonmesq.identifyservice.user.dto.ChangePasswordRequest;
import com.andersonmesq.identifyservice.user.dto.UpdateUserRequest;
import com.andersonmesq.identifyservice.user.dto.UserResponse;
import com.andersonmesq.identifyservice.user.exception.SamePasswordException;
import com.andersonmesq.identifyservice.user.exception.UserNotFoundException;
import com.andersonmesq.identifyservice.user.mapper.UserMapper;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final SecurityUtils securityUtils;

    private User getCurrentUser() {
        UUID userId = securityUtils.getPrincipal().getUserId();
        return repository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public UserResponse findMe() {
        return mapper.toResponse(getCurrentUser());
    }

    @Transactional
    public UserResponse updateProfile(UpdateUserRequest request) {
        User user = getCurrentUser();
        user.setFullName(request.fullName());
        return mapper.toResponse(user);
    }

    @Transactional
    public void changePassword(ChangePasswordRequest request) {
        User user = getCurrentUser();
        if(!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new SamePasswordException("New password is equal current password");
        }
        user.setPassword(passwordEncoder.encode(request.newPassword()));
    }
}