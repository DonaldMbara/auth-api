package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.Application;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
  Optional<Application> findByApplicationId(Long applicationId);
}
