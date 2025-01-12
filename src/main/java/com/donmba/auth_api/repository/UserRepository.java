package com.donmba.auth_api.repository;

import com.donmba.auth_api.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserId(@Param("userId") Long userId);

  User findByUserName(String userName);

  User findByEmail(String email);

  boolean existsByUserName(String userName);
}
