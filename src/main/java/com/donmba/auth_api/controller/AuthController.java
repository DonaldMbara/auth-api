package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.auth.AuthenticationRequest;
import com.donmba.auth_api.dto.user.UserRequest;
import com.donmba.auth_api.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Endpoints related to authentication operations")
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthenticationService authenticationService;

  @Operation(
      summary = "Logs in user and provide bearer token",
      description = "Provide an username and password to give you access to the system")
  @PostMapping("/login")
  public ApiResponse<String> login(
      @RequestBody AuthenticationRequest authenticationRequest, @RequestParam String redirectUri, HttpServletResponse response) {
    return authenticationService.authenticate(authenticationRequest, redirectUri, response);
  }

  @Operation(summary = "Creates a user")
  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody UserRequest userRequest) {
    authenticationService.createUser(userRequest);
  }
}
