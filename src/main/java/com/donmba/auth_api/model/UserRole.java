package com.donmba.auth_api.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "UserRole")
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "UserRoleId")
  private Long userRoleId;

  @Column(name = "CreatedAt")
  private Timestamp createdAt;

  @Column(name = "CreatedBy", nullable = false)
  private Long createdBy;

  @ManyToOne
  @JoinColumn(name = "UserId", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "RoleId", nullable = false)
  private Role role;
}
