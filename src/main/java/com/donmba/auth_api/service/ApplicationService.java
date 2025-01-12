package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.ApiResponse;
import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.exceptions.ResourceNotFoundException;
import com.donmba.auth_api.model.Application;
import com.donmba.auth_api.repository.ApplicationRepository;
import com.donmba.auth_api.utils.ApplicationMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {

  private final ApplicationRepository applicationRepository;

  public ApiResponse<ApplicationResponse> getApplication(long id) {
    if (id <= 0) {
      throw new IllegalArgumentException("Invalid application ID");
    }

    Application application =
        applicationRepository
            .findByApplicationId(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Application not found with id: " + id));

    ApplicationResponse applicationResponse =
        ApplicationMapper.mapToApplicationResponse(application);

    return ApiResponse.<ApplicationResponse>builder()
        .message("Application fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(applicationResponse)
        .build();
  }

  public ApiResponse<List<ApplicationResponse>> getApplications() {
    List<Application> applications = applicationRepository.findAll();
    List<ApplicationResponse> applicationResponses =
        applications.stream().map(ApplicationMapper::mapToApplicationResponse).toList();

    return ApiResponse.<List<ApplicationResponse>>builder()
        .message("Applications fetched successfully")
        .statusCode(HttpStatus.OK.value())
        .data(applicationResponses)
        .build();
  }
}
