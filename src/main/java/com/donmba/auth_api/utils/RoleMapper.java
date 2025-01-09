package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.model.Role;

public class RoleMapper {

  public static RoleResponse mapToRoleResponse(Role role) {
    return RoleResponse.builder()
        .roleId(role.getRoleId())
        .applicationId(role.getRoleId())
        .roleName(role.getRoleName())
        .description(role.getDescription())
        .createdBy(role.getCreatedBy())
        .createdAt(role.getCreatedAt())
        .build();
  }
}
