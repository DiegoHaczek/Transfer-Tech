package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
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
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "ACCOUNT_NUMBER",
            unique = true)
    private BigInteger accountNumber;

    @Column(name = "ALIAS",
            unique = true)
    private String alias;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "QR"
     //       ,unique = true

    )
    private String QR;

    @Column(name = "ACTIVE")
    private boolean active;

    public void subtractBalance(Double amount){
        this.balance-=amount;
    }

    public void addBalance(Double amount){
        this.balance+=amount;
    }

    public void deactive(){
        this.active=false;
    }
}
