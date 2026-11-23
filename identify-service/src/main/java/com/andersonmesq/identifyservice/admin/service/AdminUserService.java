package com.andersonmesq.identifyservice.admin.service;

import com.andersonmesq.identifyservice.admin.dto.CreateUserRequest;
import com.andersonmesq.identifyservice.admin.exception.UserNameAlreadyExistException;
import com.andersonmesq.identifyservice.admin.mapper.AdminUserMapper;
import com.andersonmesq.identifyservice.user.dto.UpdateUserRequest;
import com.andersonmesq.identifyservice.user.dto.UserResponse;
import com.andersonmesq.identifyservice.user.exception.UserAlreadyActiveException;
import com.andersonmesq.identifyservice.user.exception.UserAlreadyDeactivatedException;
import com.andersonmesq.identifyservice.user.exception.UserNotFoundException;
import com.andersonmesq.identifyservice.user.exception.UserWithoutUserAndEmailException;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.user.repository.UserRepository;
import com.andersonmesq.identifyservice.user.systemrole.SystemRole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminUserService {
    private final UserRepository repository;
    private final AdminUserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    private User findUser(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public UserResponse findById(UUID id) {
        User user = findUser(id);
        return mapper.toResponse(user);
    }

    public UserResponse findByEmail(String email) {
        User user = repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapper.toResponse(user);
    }

    public Page<UserResponse> findAll(@PageableDefault(size = 20) Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Transactional
    public UserResponse create(@Valid CreateUserRequest request){
        if (repository.existsByUserName(request.userName())) throw new UserNameAlreadyExistException("User already exist");
        User user = User.builder()
                .fullName(request.fullName())
                .userName(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .systemRole(SystemRole.USER)
                .enabled(true)
                .build();
        repository.save(user);
        if (user.getUserName() == null && user.getEmail() == null) throw new UserWithoutUserAndEmailException("User must have at least a username or an email");
        return mapper.toResponse(user);
    }

    @Transactional
    public UserResponse update(UUID id, UpdateUserRequest request){
        User user = findUser(id);
        user.setFullName(request.fullName());
        return mapper.toResponse(user);
    }

    @Transactional
    public void activate(UUID id){
        User user = findUser(id);
        if(Boolean.TRUE.equals(user.getEnabled())) throw new UserAlreadyActiveException("User already active");
        user.setEnabled(true);
    }

    @Transactional
    public void deactivate(UUID id){
        User user = findUser(id);
        if(Boolean.FALSE.equals(user.getEnabled())) throw new UserAlreadyDeactivatedException("User already deactivated");
        user.setEnabled(false);
    }
}