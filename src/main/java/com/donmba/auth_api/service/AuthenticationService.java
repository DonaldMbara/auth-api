package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired private JwtUtil jwtUtil;

  public ApiResponse<String> authenticate(String userName, String password) {
    User user = userRepository.findByUserName(userName);

    if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
      String token = jwtUtil.generateToken(userName);

      return ApiResponse.<String>builder()
          .message("Authentication successful")
          .statusCode(HttpStatus.OK.value())
          .data(token)
          .build();
    } else {
      // Invalid username or password
      return ApiResponse.<String>builder()
          .message("Invalid credentials")
          .statusCode(HttpStatus.UNAUTHORIZED.value())
          .data(null)
          .build();
    }
  }

  //    public void updatePassword(String password, User user){
  //        String hashedPassword = passwordEncoder.encode(password);
  //        user.setPasswordHash(hashedPassword);
  //        userRepository.save(user);
  //        log.info("Password updated successfully for user {}", user.getUserName());
  //    }
}
