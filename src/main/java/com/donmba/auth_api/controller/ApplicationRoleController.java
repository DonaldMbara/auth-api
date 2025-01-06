package com.donmba.auth_api.controller;


import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.dto.application.role.ApplicationRoleResponse;
import com.donmba.auth_api.service.ApplicationRoleService;
import com.donmba.auth_api.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ApplicationRoleController {
    private final ApplicationRoleService applicationRoleService;

    @GetMapping("/applicationRoleId/{applicationRoleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApplicationRoleResponse> getApplicationRole(@PathVariable("applicationRoleId") Long applicationRoleId){
        Optional<ApplicationRoleResponse> applicationRoleIdResponse = applicationRoleService.getApplicationRole(applicationRoleId);

        return applicationRoleIdResponse
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/applicationRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationRoleResponse> getApplicationRoles(){
        return applicationRoleService.getApplicationRoles();
    }

}
