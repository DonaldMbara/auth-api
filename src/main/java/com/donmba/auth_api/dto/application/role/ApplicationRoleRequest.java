package com.donmba.auth_api.dto.application.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRoleRequest {
    private long applicationId;
    private int active;
    private long createdBy;
}
