package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.model.User;

import java.util.Optional;

public class UserMapper {
    public static UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(Optional.ofNullable(user.getUserName()).orElse("N/A"))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .createdBy(user.getCreatedBy())
                .createdAt(user.getCreatedAt())
                .build();
    }

}

