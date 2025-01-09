package com.donmba.auth_api.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthenticationRequest {

  private String userName;
  private String
      passwordHash; // TODO: this is currently security flaw, make sure we rehash code and not pass
  // hashed in payload
}
