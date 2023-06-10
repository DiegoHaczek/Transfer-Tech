package com.transferTech.backend.dto.movement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositRequestDto {
    private Long receiverAccountId;
    private Double amount;
}
