package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.ApplicationRole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ApplicationRoleRepository extends JpaRepository<ApplicationRole, Long> {
  Optional<ApplicationRole> findByApplicationRoleId(
      @Param("applicationRoleId") Long applicationRoleId);
}
