package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL",
            unique = true)

    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;
}
