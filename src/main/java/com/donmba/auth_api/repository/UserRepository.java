package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
public interface UserRepository {
    @Query("SELECT u FROM User u WHERE u.UserId = :userId")
    Optional<User> findByUserId(@Param("userId") long userId);
}
