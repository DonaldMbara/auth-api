package com.donmba.auth_api.utils;

import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.model.Application;

public class ApplicationMapper {

  public static ApplicationResponse mapToApplicationResponse(Application application) {
    return ApplicationResponse.builder()
        .applicationId(application.getApplicationId())
        .applicationName(application.getApplicationName())
        .applicationSecret(application.getApplicationSecret())
        .createdAt(application.getCreatedAt())
        .createdBy(application.getCreatedBy())
        .build();
  }
}
