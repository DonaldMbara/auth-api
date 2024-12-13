package com.donmba.auth_api.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApplicationResponse {
    private String applicationName;
    private String applicationSecret;
    private Timestamp createdAt;
    private String createdBy;
}
