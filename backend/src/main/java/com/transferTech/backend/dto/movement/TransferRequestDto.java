package com.transferTech.backend.dto.movement;

import com.transferTech.backend.entity.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransferRequestDto {
    private Long receiverAccountId;
    private Long senderAccountId;
    private String description;
    private Double amount;
}
