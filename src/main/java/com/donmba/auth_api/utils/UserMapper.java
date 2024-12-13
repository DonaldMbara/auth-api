package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.model.User;

public class UserMapper {
    public static UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .createdBy(user.getUserId())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

