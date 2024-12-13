package com.donmba.auth_api.dto.application.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApplicationRoleResponse {
    private long applicationId;
    private long userId;
    private long createdBy;
    private Timestamp createdAt;
}
