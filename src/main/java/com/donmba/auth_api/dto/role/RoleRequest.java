package com.donmba.auth_api.dto.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoleRequest {
  private Long applicationId;
  private String roleName;
  private String description;
  private Long createdBy = 1L;
}
