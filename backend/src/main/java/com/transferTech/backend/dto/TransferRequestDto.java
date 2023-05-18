package com.transferTech.backend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

    @NotNull(message = "Receiver Account identifier must be provided")
    private Long receiverAccountId;

    @Pattern(regexp = "[a-zA-Z1-9ñÑ ]{1,25}",
            message = "Description must be only alphanumerical with 25 characters at must")
    private String description;

    @DecimalMin(value = "0.01", message = "Weight must be greater than 0.01")
    private Double amount;

}
