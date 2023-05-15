package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {

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

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    @Enumerated(EnumType.STRING)
    private List<Role> role;
}
