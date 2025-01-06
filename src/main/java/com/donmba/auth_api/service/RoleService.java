package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.model.Role;
import com.donmba.auth_api.repository.RoleRepository;
import com.donmba.auth_api.utils.RoleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<RoleResponse> getRole(long id) {
        return roleRepository.findByRoleId(id)
                .map(RoleMapper::mapToRoleResponse)
                .or(() -> {
                    throw new EntityNotFoundException("Role not found with id: " + id);
                });
    }

    public List<RoleResponse> getRoles() {
        List<Role> Roles = roleRepository.findAll();

        return Roles.stream()
                .map(RoleMapper::mapToRoleResponse)
                .toList();

    }
}
