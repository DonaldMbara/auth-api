package com.donmba.auth_api.dto.user.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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
