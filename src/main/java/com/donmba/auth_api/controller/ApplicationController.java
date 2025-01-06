package com.donmba.auth_api.controller;

import com.donmba.auth_api.dto.application.ApplicationResponse;
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
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/applicationId/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApplicationResponse> getApplication(@PathVariable("applicationId") Long applicationId){
        Optional<ApplicationResponse> applicationResponse = applicationService.getApplication(applicationId);

        return applicationResponse
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/applications")
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationResponse> getApplications(){
        return applicationService.getApplications();
    }

}
