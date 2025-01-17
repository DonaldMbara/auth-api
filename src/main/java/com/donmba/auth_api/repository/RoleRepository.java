package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByRoleId(@Param("roleId") Long roleId);
}
