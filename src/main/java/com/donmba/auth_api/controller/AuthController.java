package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.auth.AuthenticationRequest;
import com.donmba.auth_api.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired private AuthenticationService authenticationService;

  @Operation(
      summary = "Logs in user and provide bearer token",
      description = "Provide an username and password to give you access to the system")
  @PostMapping("/login")
  public ApiResponse<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
    return authenticationService.authenticate(
        authenticationRequest.getUserName(), authenticationRequest.getPasswordHash());
  }
}
