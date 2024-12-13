package com.donmba.auth_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponse {

    private long userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private long createdBy;
    private Timestamp createdAt;
}
