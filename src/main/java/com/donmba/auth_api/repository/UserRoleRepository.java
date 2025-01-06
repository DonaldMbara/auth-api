package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByUserRoleId(@Param("userRoleId") Long userRoleId);
}
