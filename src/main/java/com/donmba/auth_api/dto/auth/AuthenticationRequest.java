package com.donmba.auth_api.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthenticationRequest {

  @NotBlank(message = "Username cannot be empty")
  private String userName;

  @NotBlank(message = "Password cannot be empty")
  private String passwordHash;
}
