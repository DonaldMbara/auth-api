package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.role.RoleResponse;
import com.donmba.auth_api.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "Get a role by id", description = "Provide an id to look up a specific role from the system")
    @GetMapping("/roleId/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RoleResponse> getRole(@PathVariable("roleId") Long roleId){
        return roleService.getRole(roleId);
    }

    @Operation(summary = "Get all roles description for the applications")
    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<RoleResponse>> getRoles(){

        return roleService.getRoles();
    }

}
