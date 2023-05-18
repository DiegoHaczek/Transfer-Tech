package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", deposits=" + deposits +
                ", transfers=" + transfers +
                ", alias='" + alias + '\'' +
                ", balance=" + balance +
                ", QR='" + QR + '\'' +
                ", Active=" + Active +
                '}';
    }
}
