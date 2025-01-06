package com.donmba.auth_api.dto.user.role;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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
