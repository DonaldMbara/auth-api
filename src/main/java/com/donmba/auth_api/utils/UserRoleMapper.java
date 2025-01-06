package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.model.UserRole;

import java.sql.Timestamp;

public class UserRoleMapper {

    public static UserRoleResponse mapToUserRoleResponse(UserRole userRole){
        return UserRoleResponse.builder()
                .userRoleId(userRole.getUserRoleId())
                .applicationRoleId(userRole.getUserRoleId())
                .userId(userRole.getUser().getUserId())
                .createdBy(userRole.getUserRoleId())
                .createdAt(userRole.getCreatedAt())
                .build();
    }
}
