package com.donmba.auth_api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
  private Timestamp createdAt;
  private Long createdBy;
  private int active;
}
