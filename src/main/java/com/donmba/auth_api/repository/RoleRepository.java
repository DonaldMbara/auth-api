package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository {
    @Query("SELECT r FROM Role r WHERE r.userId = :roleId")
    Optional<Role> findByRoleId(@Param("roleId") long roleId);
}
