package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleId(long roleId);
}
