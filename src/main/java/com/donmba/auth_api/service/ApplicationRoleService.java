package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.model.Application;
import com.donmba.auth_api.model.ApplicationRole;
import com.donmba.auth_api.repository.ApplicationRoleRepository;
import com.donmba.auth_api.utils.ApplicationMapper;
import com.donmba.auth_api.utils.ApplicationRoleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationRoleService {

    private final ApplicationRoleRepository applicationRoleRepository;

    public Optional<ApplicationRoleResponse> getApplicationRole(long id) {
        return applicationRoleRepository.findByApplicationRoleId(id)
                .map(ApplicationRoleMapper::mapToApplicationRoleResponse)
                .or(() -> {
                    throw new EntityNotFoundException("ApplicationRole not found with id: " + id);
                });
    }

    public List<ApplicationRoleResponse> getApplicationRoles() {
        List<ApplicationRole> applicationRoles = applicationRoleRepository.findAll();

        return applicationRoles.stream()
                .map(ApplicationRoleMapper::mapToApplicationRoleResponse)
                .toList();

    }
}
