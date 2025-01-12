package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.exceptions.ResourceNotFoundException;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.utils.UserMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public ApiResponse<UserResponse> getUser(long id) {
    if (id <= 0) {
      throw new IllegalArgumentException("Invalid User ID");
    }

    // Fetch the user or throw ResourceNotFoundException if not found
    User user =
        userRepository
            .findByUserId(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

    // Map to UserResponse and return it
    UserResponse userResponse = UserMapper.mapToUserResponse(user);

    log.info("Fetched user with ID: {}", id);

    return ApiResponse.<UserResponse>builder()
        .message("User fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(userResponse)
        .build();
  }

  public ApiResponse<List<UserResponse>> getUsers() {
    List<User> users = userRepository.findAll();
    List<UserResponse> userResponses = users.stream().map(UserMapper::mapToUserResponse).toList();

    log.info("Fetched all users");

    return ApiResponse.<List<UserResponse>>builder()
        .message("Users fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(userResponses)
        .build();
  }
}
