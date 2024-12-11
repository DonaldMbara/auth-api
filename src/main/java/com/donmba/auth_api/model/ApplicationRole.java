package com.donmba.auth_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "ApplicationRole")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ApplicationRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationRoleId")
    private int applicationRoleId;

    @Column(name = "ApplicationId")
    private String applicationId;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "CreatedByUserId")
    private String createdBy;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;


}
