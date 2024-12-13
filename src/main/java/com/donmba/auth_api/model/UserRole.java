package com.donmba.auth_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "UserRole")
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

public class UserRole {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "UserRoleId")
    private long userRoleId;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "CreatedBy", nullable = false)
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "ApplicationId", referencedColumnName = "ApplicationId", foreignKey = @ForeignKey(name = "FK_ApplicationRole_Application"))
    private Application application;
}
