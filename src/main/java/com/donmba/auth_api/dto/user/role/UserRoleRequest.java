package com.donmba.auth_api.dto.user.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRoleRequest {

  private Long applicationRoleId;
  private Long userId;
  private Long userRoleId;
  private Long createdBy;
}
