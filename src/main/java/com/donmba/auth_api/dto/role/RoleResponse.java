package com.donmba.auth_api.dto.role;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoleResponse {
  private Long roleId;
  private Long applicationId;
  private String roleName;
  private String description;
  private Long createdBy;
  private Timestamp createdAt;
}
