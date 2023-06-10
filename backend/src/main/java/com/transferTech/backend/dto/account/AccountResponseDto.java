package com.transferTech.backend.dto.account;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AccountResponseDto {

    private Long id;
    private String userName;
    private String accountNumber;
    private String alias;
    private Double balance;
    private String QR;
    private boolean active;
    private String cardNumber;
    private String cardIssuance;
    private String cardExpiration;
    private Integer cardCvv;
    private Boolean cardActive;
}
