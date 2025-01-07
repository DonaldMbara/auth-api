package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(summary = "Get a application by id", description = "Provide an id to look up a specific application from the system")
    @GetMapping("/applicationId/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ApplicationResponse> getApplication(@PathVariable("applicationId") Long applicationId){
        return applicationService.getApplication(applicationId);
    }

    @Operation(summary = "Get all applications")
    @GetMapping("/applications")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<ApplicationResponse>> getApplications() {
        return applicationService.getApplications();
    }
}
