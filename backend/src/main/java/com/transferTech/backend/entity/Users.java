package com.transferTech.backend.entity;

import lombok.Data;

@Data
public class Users {

    private Long id;
    private String email;
    private String password;
    private String name;
}
