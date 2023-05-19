package com.transferTech.backend.dto;

import com.transferTech.backend.entity.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositRequestDto {
    private Long receiverAccountId;
    private Double amount;
}
