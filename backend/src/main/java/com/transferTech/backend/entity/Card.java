package com.transferTech.backend.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARDS")
public class Card {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "CARD_NUMBER",
            unique = true)
    private BigInteger number;

    @Column(name = "ISSUANCE_DATE")
    private String issuance;

    @Column(name = "EXPIRATION_DATE")
    private String expiration;

    @Column(name = "CVV")
    private Integer CVV;

    @Column(name = "ACTIVE")
    private Boolean active;

    public void activate() {
        setActive(true);
    }

    public void deactivate() {
        setActive(false);
    }

    public String getNumber() {
        return String.valueOf(number);
    }
}
