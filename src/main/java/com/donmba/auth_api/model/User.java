package com.donmba.auth_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "User")
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private long userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "CreatedBy", nullable = false)
    private String createdBy;
}
