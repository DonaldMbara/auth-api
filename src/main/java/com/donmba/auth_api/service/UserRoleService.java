package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.model.UserRole;
import com.donmba.auth_api.repository.UserRoleRepository;
import com.donmba.auth_api.utils.UserRoleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public Optional<UserRoleResponse> getUserRole(long id) {
        return userRoleRepository.findByUserRoleId(id)
                .map(UserRoleMapper::mapToUserRoleResponse)
                .or(() -> {
                    throw new EntityNotFoundException("UserRole not found with id: " + id);
                });
    }

    public List<UserRoleResponse> getUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();

        return userRoles.stream()
                .map(UserRoleMapper::mapToUserRoleResponse)
                .toList();

    }
}
