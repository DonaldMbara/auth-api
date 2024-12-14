package com.donmba.auth_api.service;

import com.donmba.auth_api.dto.user.UserResponse;
import com.donmba.auth_api.model.User;
import com.donmba.auth_api.repository.UserRepository;
import com.donmba.auth_api.utils.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public Optional<UserResponse> getUser(long id) {
        return userRepository.findByUserId(id)
                .map(UserMapper::mapToUserResponse)
                .or(() -> {
                    log.error("User not found with id: {}", id);
                    throw new EntityNotFoundException("User not found with id: " + id);
                });
    }

}
