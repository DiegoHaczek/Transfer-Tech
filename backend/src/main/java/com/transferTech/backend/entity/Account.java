package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "ACCOUNT_NUMBER",
            unique = true)
    private int accountNumber;

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Deposit> deposits;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Transfer> transfers;

    @Column(name = "ALIAS",
            unique = true)
    private String alias;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "QR",
            unique = true)
    private String QR;

    @Column(name = "ACTIVE")
    private boolean Active;

}
