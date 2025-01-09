package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.model.ApplicationRole;
import com.donmba.auth_api.repository.ApplicationRoleRepository;
import com.donmba.auth_api.utils.ApplicationRoleMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationRoleService {

  private final ApplicationRoleRepository applicationRoleRepository;

  public ApiResponse<ApplicationRoleResponse> getApplicationRole(long id) {
    Optional<ApplicationRole> applicationRole =
        applicationRoleRepository.findByApplicationRoleId(id);

    if (applicationRole.isPresent()) {
      ApplicationRoleResponse applicationRoleResponse =
          ApplicationRoleMapper.mapToApplicationRoleResponse(applicationRole.get());
      return ApiResponse.<ApplicationRoleResponse>builder()
          .message("ApplicationRole fetched successfully")
          .statusCode(HttpStatus.OK.value())
          .data(applicationRoleResponse)
          .build();
    } else {
      return ApiResponse.<ApplicationRoleResponse>builder()
          .message("ApplicationRole not found with id: " + id)
          .statusCode(HttpStatus.NOT_FOUND.value())
          .data(null)
          .build();
    }
  }

  public ApiResponse<List<ApplicationRoleResponse>> getApplicationRoles() {
    List<ApplicationRole> applicationRoles = applicationRoleRepository.findAll();
    List<ApplicationRoleResponse> applicationRoleResponses =
        applicationRoles.stream().map(ApplicationRoleMapper::mapToApplicationRoleResponse).toList();

    return ApiResponse.<List<ApplicationRoleResponse>>builder()
        .message("ApplicationRoles fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(applicationRoleResponses)
        .build();
  }
}
