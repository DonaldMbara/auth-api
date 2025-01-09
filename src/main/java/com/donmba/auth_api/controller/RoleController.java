package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Role", description = "Endpoints related to application roles operations")
@RequiredArgsConstructor
public class RoleController {

  private final RoleService roleService;

  @Operation(
      summary = "Get a role by id",
      description = "Provide an id to look up a specific role from the system")
  @GetMapping("/roleId/{roleId}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<RoleResponse> getRole(@PathVariable("roleId") Long roleId) {
    return roleService.getRole(roleId);
  }

  @Operation(summary = "Get all roles description for the applications")
  @GetMapping("/roles")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<List<RoleResponse>> getRoles() {

    return roleService.getRoles();
  }
}
