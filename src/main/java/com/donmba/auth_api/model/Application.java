package com.donmba.auth_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "Application")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationId")
    private  long applicationId;

    @Column(name = "ApplicationName")
    private String applicationName;

    @Column(name = "ApplicationSecret")
    private String applicationSecret;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "CreatedBy")
    private String createdBy;
}
