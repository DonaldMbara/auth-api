package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roleId/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RoleResponse> getRole(@PathVariable("roleId") Long roleId){
        return roleService.getRole(roleId);
    }

    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<RoleResponse>> getRoles(){

        return roleService.getRoles();
    }

}
