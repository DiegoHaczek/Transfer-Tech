package com.transferTech.backend.dto.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInfoDto {
    private Long id;
    private String userName;
    private String accountNumber;
    private String alias;
    private String QR;
}
