package com.transferTech.backend.dto.movement;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class MovementDto {
    private Long id;
    private String userName;
    private String type;
    private String description;
    private String dateTime;
    private Double amount;
}
