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
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ApplicationRoleId", nullable = false)
    private ApplicationRole applicationRole;
}
