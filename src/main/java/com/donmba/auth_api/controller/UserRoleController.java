package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping("/userRoleId/{userRoleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserRoleResponse> getUserRole(@PathVariable("userRoleId") Long userRoleId){
        return userRoleService.getUserRole(userRoleId);
    }

    @GetMapping("/userRoles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<UserRoleResponse>> getRoles(){
        return userRoleService.getUserRoles();
    }

}
