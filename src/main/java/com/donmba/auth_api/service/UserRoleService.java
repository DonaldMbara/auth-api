package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.model.UserRole;
import com.donmba.auth_api.repository.UserRoleRepository;
import com.donmba.auth_api.utils.UserRoleMapper;
import java.util.List;
import java.util.Optional;
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
    Optional<UserRole> userRole = userRoleRepository.findByUserRoleId(id);

    if (userRole.isPresent()) {
      UserRoleResponse userRoleResponse = UserRoleMapper.mapToUserRoleResponse(userRole.get());
      return ApiResponse.<UserRoleResponse>builder()
          .message("UserRole fetched successfully")
          .statusCode(HttpStatus.OK.value())
          .data(userRoleResponse)
          .build();
    } else {
      return ApiResponse.<UserRoleResponse>builder()
          .message("UserRole not found with id: " + id)
          .statusCode(HttpStatus.NOT_FOUND.value())
          .data(null)
          .build();
    }
  }

  public ApiResponse<List<UserRoleResponse>> getUserRoles() {
    List<UserRole> userRoles = userRoleRepository.findAll();
    List<UserRoleResponse> userRoleResponses =
        userRoles.stream().map(UserRoleMapper::mapToUserRoleResponse).toList();

    return ApiResponse.<List<UserRoleResponse>>builder()
        .message("UserRoles fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(userRoleResponses)
        .build();
  }
}
