package com.donmba.auth_api.dto.application.role;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApplicationRoleResponse {
  private Long applicationRoleId;
  private Long applicationId;
  private int active;
  private Long createdBy;
  private Timestamp createdAt;
}
