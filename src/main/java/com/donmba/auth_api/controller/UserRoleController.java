package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.dto.user.role.UserRoleResponse;
import com.donmba.auth_api.service.RoleService;
import com.donmba.auth_api.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping("/userRoleId/{userRoleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserRoleResponse> getUserRole(@PathVariable("userRoleId") Long userRoleId){
        Optional<UserRoleResponse> userRoleResponse = userRoleService.getUserRole(userRoleId);

        return userRoleResponse
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/userRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<UserRoleResponse> getRoles(){
        return userRoleService.getUserRoles();
    }

}
