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
    @Column(name = "UserId")
    private long userId;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ApplicationId")
    private String applicationId;
}
