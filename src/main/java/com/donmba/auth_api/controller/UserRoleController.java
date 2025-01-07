package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.service.UserRoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Operation(summary = "Get a user role by id", description = "Provide an id to look up a specific user role from the system")
    @GetMapping("/userRoleId/{userRoleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserRoleResponse> getUserRole(@PathVariable("userRoleId") Long userRoleId){
        return userRoleService.getUserRole(userRoleId);
    }

    @Operation(summary = "Get all user roles")
    @GetMapping("/userRoles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<UserRoleResponse>> getRoles(){
        return userRoleService.getUserRoles();
    }

}