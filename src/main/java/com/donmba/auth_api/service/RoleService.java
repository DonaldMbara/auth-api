package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.exceptions.ResourceNotFoundException;
import com.donmba.auth_api.model.Role;
import com.donmba.auth_api.repository.RoleRepository;
import com.donmba.auth_api.utils.RoleMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

  private final RoleRepository roleRepository;

  public ApiResponse<RoleResponse> getRole(long id) {
    log.info("Fetching role with ID: {}", id);

    Optional<Role> role = roleRepository.findByRoleId(id);

    if (role.isPresent()) {
      RoleResponse roleResponse = RoleMapper.mapToRoleResponse(role.get());
      log.info("Role with ID: {} fetched successfully", id);
      return ApiResponse.<RoleResponse>builder()
          .message("Role fetched successfully")
          .statusCode(HttpStatus.OK.value())
          .data(roleResponse)
          .build();
    } else {
      log.error("Role with ID: {} not found", id);
      throw new ResourceNotFoundException("Role not found with id: " + id);
    }
  }

  public ApiResponse<List<RoleResponse>> getRoles() {
    log.info("Fetching all roles");

    List<Role> roles = roleRepository.findAll();
    List<RoleResponse> roleResponses = roles.stream().map(RoleMapper::mapToRoleResponse).toList();

    log.info("Fetched {} roles successfully", roles.size());
    return ApiResponse.<List<RoleResponse>>builder()
        .message("Roles fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(roleResponses)
        .build();
  }
}
