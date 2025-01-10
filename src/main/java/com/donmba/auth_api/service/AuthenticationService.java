package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.auth.AuthenticationRequest;
import com.donmba.auth_api.dto.user.UserRequest;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.security.JwtUtil;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
      @RequestBody AuthenticationRequest loginRequest, @RequestParam String redirectUri, HttpServletResponse response) {

    String userName = loginRequest.getUserName();
    String password = loginRequest.getPasswordHash();

    User user = userRepository.findByUserName(userName);

    if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
      String token = jwtUtil.generateToken(userName);

      // Set the token in a secure, HTTP-only cookie
      ResponseCookie cookie =
          ResponseCookie.from("authToken", token)
              .httpOnly(true)
              .secure(true)
              .path("/")
              .maxAge(3600) // Token valid for 1 hour
              .build();

      // Add cookie to response
      response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

      // Validate the redirect URI
      if (!isValidRedirectUri(redirectUri)) {
        return ApiResponse.<String>builder()
            .message("Invalid redirect URI")
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .data(null)
            .build();
      }

      // Add the cookie to the response and redirect
      return ApiResponse.<String>builder()
          .message("Login successful, redirecting...")
          .statusCode(HttpStatus.FOUND.value())
          .data(token)
          .build();
    } else {
      return ApiResponse.<String>builder()
          .message("Invalid credentials")
          .statusCode(HttpStatus.UNAUTHORIZED.value())
          .data(null)
          .build();
    }
  }

  // TODO: Helper Method to Validate Redirect URIs
  private boolean isValidRedirectUri(String redirectUri) {
    // Dummy WHITELIST
    List<String> allowedUris = List.of("https://www.google.com/");
    return allowedUris.contains(redirectUri);
  }

  public String createUser(UserRequest userRequest) {

    String hashedPassword = passwordEncoder.encode(userRequest.getPasswordHash());

    User user =
        User.builder()
            .userName(userRequest.getUserName())
            .email(userRequest.getEmail())
            .firstName(userRequest.getFirstName())
            .lastName(userRequest.getLastName())
            .passwordHash(hashedPassword)
            .createdBy(userRequest.getCreatedBy())
            .createdAt(userRequest.getCreatedAt())
            .active(userRequest.getActive())
            .build();

    userRepository.save(user);
    log.info("User {} is created", user.getUserName());
    return "User {} is created";
  }
}
