package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "PROFILES")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "AGE")
    private int age;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private int zipCode;

    @Column(name = "PROFILE_IMG")
    private String profileImg;

}
