package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRoleRepository {
    @Query("SELECT r FROM UserRole r WHERE r.userRoleId = :userRoleId")
    Optional<UserRole> findByUserRoleId(@Param("userRoleId") long userRoleId);
}
