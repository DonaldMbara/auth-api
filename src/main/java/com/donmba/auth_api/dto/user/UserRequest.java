package com.donmba.auth_api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

  @NotBlank(message = "Username cannot be empty")
  private String userName;

  @Email(message = "Email should be valid")
  @NotBlank(message = "Email cannot be empty")
  private String email;

  @NotBlank(message = "Password cannot be empty")
  @Size(min = 8, message = "Password should be at least 8 characters")
  private String passwordHash;

  private String firstName;
  private String lastName;
  private Instant createdAt;
  private Long createdBy;
  private int active;

  // Builder default values for fields
  public static class UserRequestBuilder {
    private Instant createdAt = Instant.now(); // Default to current timestamp
    private Long createdBy = 1L; // Default to system user
    private int active = 1; // Default to active status
  }
}
