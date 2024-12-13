package com.donmba.auth_api.dto.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoleResponse {
    private String roleName;
    private long createdBy;
    private Timestamp createdAt;
}
