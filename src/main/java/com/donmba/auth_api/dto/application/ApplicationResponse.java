package com.donmba.auth_api.dto.application;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApplicationResponse {
  private Long applicationId;
  private String applicationName;
  private String applicationSecret;
  private Timestamp createdAt;
  private Long createdBy;
}
