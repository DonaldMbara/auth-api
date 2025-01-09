package com.donmba.auth_api.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Role")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "RoleId")
  private Long roleId;

  @ManyToOne
  @JoinColumn(name = "ApplicationId", nullable = false)
  private Application application;

  @Column(name = "RoleName")
  private String roleName;

  @Column(name = "Description")
  private String description;

  @Column(name = "CreatedAt")
  private Timestamp createdAt;

  @Column(name = "CreatedBy", nullable = false)
  private long createdBy;
}
