package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.application.ApplicationResponse;
import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.model.Application;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.ApplicationRepository;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.utils.ApplicationMapper;
import com.donmba.auth_api.utils.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public Optional<ApplicationResponse> getApplication(long id) {
        return applicationRepository.findByApplicationId(id)
                .map(ApplicationMapper::mapToApplicationResponse)
                .or(() -> {
                    throw new EntityNotFoundException("Application not found with id: " + id);
                });
    }

    public List<ApplicationResponse> getApplications() {
        List<Application> applications = applicationRepository.findAll();

        return applications.stream()
                .map(ApplicationMapper::mapToApplicationResponse)
                .toList();

    }
}
