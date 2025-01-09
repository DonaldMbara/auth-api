package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.UserRequest;
import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @Operation(
      summary = "Get a user by id",
      description = "Provide an id to look up a specific user from the system")
  @GetMapping("/userId/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<UserResponse> getUser(@PathVariable("userId") Long userId) {
    return userService.getUser(userId);
  }

  @Operation(summary = "Get all users")
  @GetMapping("/users")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<List<UserResponse>> getUsers() {

    return userService.getUsers();
  }

  @Operation(summary = "Creates a user")
  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody UserRequest userRequest) {
    userService.createUser(userRequest);
  }
}
