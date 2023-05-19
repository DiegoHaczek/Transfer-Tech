package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSFERS")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TRANSFER_CODE",
            unique = true)
    private Long transferCode;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id",
            referencedColumnName = "ID",
            nullable = false)
    private Account receiverAccount;

    @ManyToOne
    @JoinColumn(name = "sender_account_id",
            referencedColumnName = "ID")
    private Account senderAccount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;

    private Map<String,String> generateProofOfPayment (){
        return null;
    }
}
