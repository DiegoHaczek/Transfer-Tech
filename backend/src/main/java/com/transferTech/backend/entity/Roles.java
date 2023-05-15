package com.transferTech.backend.entity;

import com.transferTech.backend.enumeration.ERole;
import jakarta.persistence.*;

public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME"
            ,unique = true)
    private ERole name;

}
