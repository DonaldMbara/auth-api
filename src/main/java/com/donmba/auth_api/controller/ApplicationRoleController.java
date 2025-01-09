package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.service.ApplicationRoleService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ApplicationRoleController {
  private final ApplicationRoleService applicationRoleService;

  @Operation(
      summary = "Get a application role by id",
      description = "Provide an id to look up a specific application role from the system")
  @GetMapping("/applicationRoleId/{applicationRoleId}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<ApplicationRoleResponse> getApplicationRole(
      @PathVariable("applicationRoleId") Long applicationRoleId) {
    return applicationRoleService.getApplicationRole(applicationRoleId);
  }

  @Operation(summary = "Get all application roles")
  @GetMapping("/applicationRoles")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<List<ApplicationRoleResponse>> getApplicationRoles() {
    return applicationRoleService.getApplicationRoles();
  }
}
