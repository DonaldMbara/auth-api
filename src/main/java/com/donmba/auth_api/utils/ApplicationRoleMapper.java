package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.model.ApplicationRole;


public class ApplicationRoleMapper {

    public static ApplicationRoleResponse mapToApplicationRoleResponse(ApplicationRole applicationRole) {
        return ApplicationRoleResponse.builder()
                .applicationRoleId(applicationRole.getApplicationRoleId())
                .applicationId(applicationRole.getApplication().getApplicationId())
                .active(applicationRole.getActive())
                .createdBy(applicationRole.getApplicationRoleId())
                .createdAt(applicationRole.getCreatedAt())
                .build();
    }
}
