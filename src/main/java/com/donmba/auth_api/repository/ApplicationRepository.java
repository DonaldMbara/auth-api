package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationRepository {
    @Query("SELECT a FROM Application a WHERE a.applicationId = :applicationId")
    Optional<Application> findByApplicationId(@Param("applicationId") long applicationId);
}
