package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.auth.AuthenticationRequest;
import com.donmba.auth_api.dto.user.UserRequest;
import com.donmba.auth_api.exceptions.InvalidCredentialsException;
import com.donmba.auth_api.exceptions.InvalidRedirectUriException;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.security.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired private JwtUtil jwtUtil;

  public ApiResponse<String> authenticate(
      @Valid @RequestBody AuthenticationRequest loginRequest,
      @RequestParam String redirectUri,
      HttpServletResponse response,
      BindingResult bindingResult) {

    // Validate input
    if (bindingResult.hasErrors()) {
      // Handle validation errors here
      StringBuilder errorMessages = new StringBuilder();
      for (ObjectError error : bindingResult.getAllErrors()) {
        errorMessages.append(error.getDefaultMessage()).append("; ");
      }
      return ApiResponse.<String>builder()
          .message("Validation failed: " + errorMessages.toString())
          .statusCode(HttpStatus.BAD_REQUEST.value())
          .data(null)
          .build();
    }

    String userName = loginRequest.getUserName();
    String password = loginRequest.getPasswordHash();

    // Authenticate user
    User user = userRepository.findByUserName(userName);

    if (user == null || !passwordEncoder.matches(password, user.getPasswordHash())) {
      throw new InvalidCredentialsException("Invalid credentials");
    }

    // Generate token and set in cookie
    String token = jwtUtil.generateToken(userName);
    ResponseCookie cookie =
        ResponseCookie.from("authToken", token)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(3600) // Token valid for 1 hour
            .build();
    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    // Validate redirect URI
    if (!isValidRedirectUri(redirectUri)) {
      throw new InvalidRedirectUriException("Invalid redirect URI");
    }

    // Set redirect header and return success response
    response.setHeader(HttpHeaders.LOCATION, redirectUri);
    return ApiResponse.<String>builder()
        .message("Login successful, redirecting...")
        .statusCode(HttpStatus.FOUND.value())
        .data(token)
        .build();
  }

  // Helper method to validate redirect URIs
  private boolean isValidRedirectUri(String redirectUri) {
    // Dummy WHITELIST of allowed URIs
    List<String> allowedUris = List.of("https://www.google.com/");
    return allowedUris.contains(redirectUri);
  }

  public ApiResponse<String> createUser(@Valid @RequestBody UserRequest userRequest) {

    // Check if username already exists
    if (userRepository.existsByUserName(userRequest.getUserName())) {
      return ApiResponse.<String>builder()
          .message("Username already exists")
          .statusCode(HttpStatus.BAD_REQUEST.value())
          .data(null)
          .build();
    }

    String hashedPassword = passwordEncoder.encode(userRequest.getPasswordHash());

    User user =
        User.builder()
            .userName(userRequest.getUserName())
            .email(userRequest.getEmail())
            .firstName(userRequest.getFirstName())
            .lastName(userRequest.getLastName())
            .passwordHash(hashedPassword)
            .createdBy(userRequest.getCreatedBy())
            .createdAt(Timestamp.from(userRequest.getCreatedAt()))
            .active(userRequest.getActive())
            .build();

    userRepository.save(user);
    log.info("User {} is created", user.getUserName());

    return ApiResponse.<String>builder()
        .message("User created successfully")
        .statusCode(HttpStatus.CREATED.value())
        .data(user.getUserName())
        .build();
  }
}
