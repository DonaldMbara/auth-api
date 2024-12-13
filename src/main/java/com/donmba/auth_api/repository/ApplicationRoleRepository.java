package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.ApplicationRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationRoleRepository {
    @Query("SELECT a FROM ApplicationRole a WHERE a.applicationRoleId = :applicationRoleId")
    Optional<ApplicationRole> findByApplicationRoleId(@Param("applicationRoleId") long applicationRoleId);
}
