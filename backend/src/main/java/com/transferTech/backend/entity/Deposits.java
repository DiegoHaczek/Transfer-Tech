package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "DEPOSITS")
public class Deposits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DATE")
    private java.util.Date Date;

    @Column(name = "HOUR")
    private Time Hour;

}
