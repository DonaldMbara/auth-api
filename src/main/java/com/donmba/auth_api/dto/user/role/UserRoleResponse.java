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
    private long applicationRoleId;
    private long userId;
    private long userRoleId;
    private long createdBy;
    private Timestamp createdAt;

}
