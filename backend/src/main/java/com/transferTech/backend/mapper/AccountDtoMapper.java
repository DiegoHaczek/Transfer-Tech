package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.account.AccountResponseDto;
import com.transferTech.backend.entity.Account;
import org.springframework.stereotype.Component;

import java.util.Map;

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


    public AccountInfoDto QueryResultRowToDto(Map<String, Object> resultRow) {
        return AccountInfoDto.builder()
                .id((Long) resultRow.get("account_id"))
                .userName((String) resultRow.get("user_name"))
                .accountNumber(resultRow.get("account_number").toString())
                .alias((String) resultRow.get("alias"))
                .QR((String) resultRow.get("qr"))
                .build();
    }
}
