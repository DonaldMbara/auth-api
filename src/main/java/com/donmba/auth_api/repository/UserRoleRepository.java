package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.UserRole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
  Optional<UserRole> findByUserRoleId(@Param("userRoleId") Long userRoleId);
}
