package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.AccountInfoDto;
import com.transferTech.backend.dto.AccountResponseDto;
import com.transferTech.backend.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoMapper {

    public AccountResponseDto EntityToDto(Account account) {
        return AccountResponseDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber().toString())
                .balance(account.getBalance())
                .active(account.isActive())
                .alias(account.getAlias())
                .QR(account.getQR())
                .userName(account.getUser().getName())
                .build();
    }

    public AccountInfoDto EntityToInfoDto(Account account){
        return AccountInfoDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber().toString())
                .alias(account.getAlias())
                .QR(account.getQR())
                .userName(account.getUser().getName())
                .build();
    }
}
