package com.donmba.auth_api.dto.user.role;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRoleResponse {
  private Long userRoleId;
  private Long applicationRoleId;
  private Long userId;
  private Long createdBy;
  private Timestamp createdAt;
}
