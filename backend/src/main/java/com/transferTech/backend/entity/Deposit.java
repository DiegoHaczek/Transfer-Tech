package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "DEPOSITS")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "ID", nullable = false)
    private Account account;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DATE")
    private java.util.Date Date;

    @Column(name = "HOUR")
    private Time Hour;

}
