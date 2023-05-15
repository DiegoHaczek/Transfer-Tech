package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "TRANSFERS")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DATE")
    private Date Date;

    @Column(name = "HOUR")
    private Time Hour;
}
