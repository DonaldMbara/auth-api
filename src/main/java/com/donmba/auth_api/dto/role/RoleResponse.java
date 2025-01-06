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
    private Long roleId;
    private String roleName;
    private Long createdBy;
    private Timestamp createdAt;
}
