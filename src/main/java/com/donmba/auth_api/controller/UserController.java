package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/id/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") long userId){
        Optional<UserResponse> userResponse = userService.getUser(userId);

        return userResponse
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
