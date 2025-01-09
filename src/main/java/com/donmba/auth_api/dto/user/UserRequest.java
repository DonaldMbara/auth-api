package com.donmba.auth_api.dto.user;

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

  private String userName;
  private String email;
  private String passwordHash;
  private String firstName;
  private String lastName;
  private Timestamp createdAt;
  private Long createdBy = 1L;
  private int active = 1;
}
