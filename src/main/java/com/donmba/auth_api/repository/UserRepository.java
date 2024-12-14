package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserId(long userId);
}
