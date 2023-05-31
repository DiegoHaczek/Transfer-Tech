package com.transferTech.backend.entity;

import com.transferTech.backend.enumeration.ERole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME",
            unique = true)
    private ERole name;

    public static ERole RoletoERole (String role) {
        return switch (role.toLowerCase()){
            case "user" -> ERole.ROLE_USER;
            case "customer" -> ERole.ROLE_CUSTOMER;
            case "admin" -> ERole.ROLE_ADMIN;
            default -> null;
        };

    }
}
