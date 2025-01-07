package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public ApiResponse<String> authenticate(String userName, String password) {
        User user = userRepository.findByUserName(userName);

        if (user != null && user.getPasswordHash().equals(password)) {
            String token = jwtUtil.generateToken(userName);

            return ApiResponse.<String>builder()
                    .message("Authentication successful")
                    .statusCode(HttpStatus.OK.value())
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
}
