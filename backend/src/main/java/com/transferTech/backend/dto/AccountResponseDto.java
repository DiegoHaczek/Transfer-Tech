package com.transferTech.backend.dto;

import com.transferTech.backend.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

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
}
