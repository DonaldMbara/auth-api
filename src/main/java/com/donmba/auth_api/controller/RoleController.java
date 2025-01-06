package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.service.ApplicationRoleService;
import com.donmba.auth_api.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roleId/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RoleResponse> getRole(@PathVariable("roleId") Long roleId){
        Optional<RoleResponse> applicationRoleIdResponse = roleService.getRole(roleId);

        return applicationRoleIdResponse
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleResponse> getRoles(){
        return roleService.getRoles();
    }

}
