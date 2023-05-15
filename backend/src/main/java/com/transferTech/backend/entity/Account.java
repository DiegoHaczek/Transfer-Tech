package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER",
            unique = true)
    private int accountNumber;

    @Column(name = "ALIAS",
            unique = true)
    private String alias;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "QR",
            unique = true)
    private String QR;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;



}
