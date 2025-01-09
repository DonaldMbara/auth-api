package com.donmba.auth_api.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ApplicationRole")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ApplicationRoleId")
  private Long applicationRoleId;

  @ManyToOne
  @JoinColumn(
      name = "ApplicationId",
      referencedColumnName = "ApplicationId",
      foreignKey = @ForeignKey(name = "FK_ApplicationRole_Application"))
  private Application application;

  @Column(name = "Active", nullable = false)
  private int active;

  @Column(name = "CreatedBy", nullable = false)
  private String createdBy;

  @Column(name = "CreatedAt", nullable = false, updatable = false)
  private Timestamp createdAt;
}
