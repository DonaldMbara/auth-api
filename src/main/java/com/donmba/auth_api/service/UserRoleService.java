package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.exceptions.ResourceNotFoundException;
import com.donmba.auth_api.model.UserRole;
import com.donmba.auth_api.repository.UserRoleRepository;
import com.donmba.auth_api.utils.UserRoleMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRoleService {

  private final UserRoleRepository userRoleRepository;

  public ApiResponse<UserRoleResponse> getUserRole(long id) {
    if (id <= 0) {
      throw new IllegalArgumentException("Invalid UserRole ID");
    }

    // Fetch the user role from the repository or throw an exception if not found
    UserRole userRole =
        userRoleRepository
            .findByUserRoleId(id)
            .orElseThrow(() -> new ResourceNotFoundException("User Role not found with id: " + id));

    // Map the UserRole to UserRoleResponse and return it
    UserRoleResponse userRoleResponse = UserRoleMapper.mapToUserRoleResponse(userRole);

    log.info("Fetched UserRole with ID: {}", id);

    return ApiResponse.<UserRoleResponse>builder()
        .message("UserRole fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(userRoleResponse)
        .build();
  }

  public ApiResponse<List<UserRoleResponse>> getUserRoles() {
    List<UserRole> userRoles = userRoleRepository.findAll();
    List<UserRoleResponse> userRoleResponses =
        userRoles.stream().map(UserRoleMapper::mapToUserRoleResponse).toList();

    log.info("Fetched all UserRoles");

    return ApiResponse.<List<UserRoleResponse>>builder()
        .message("UserRoles fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(userRoleResponses)
        .build();
  }
}
