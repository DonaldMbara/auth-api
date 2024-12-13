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
public class UserRequest {

    private String userName;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private Timestamp createdAt;
    private long createdBy;
}
