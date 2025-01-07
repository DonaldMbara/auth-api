package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public ApiResponse<UserResponse> getUser(long id) {
        Optional<User> user = userRepository.findByUserId(id);

        if (user.isPresent()) {
            UserResponse userResponse = UserMapper.mapToUserResponse(user.get());
            return ApiResponse.<UserResponse>builder()
                    .message("User fetched successfully")
                    .statusCode(HttpStatus.OK.value())
                    .data(userResponse)
                    .build();
        } else {
            return ApiResponse.<UserResponse>builder()
                    .message("User not found with id: " + id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }
    }

    public ApiResponse<List<UserResponse>> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(UserMapper::mapToUserResponse)
                .toList();

        return ApiResponse.<List<UserResponse>>builder()
                .message("Users fetched successfully")
                .statusCode(HttpStatus.OK.value())
                .data(userResponses)
                .build();
    }
}
