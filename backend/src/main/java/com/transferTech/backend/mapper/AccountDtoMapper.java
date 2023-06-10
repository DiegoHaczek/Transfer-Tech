package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.account.AccountResponseDto;
import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.Card;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccountDtoMapper {

    private final CardRepository cardRepository;

    public AccountResponseDto EntityToDto(Account account) {
        Card userCard =  cardRepository.findById(account.getId()).orElseThrow(
                ()->new NotFoundException("Error retrieving account info"));

        return AccountResponseDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber().toString())
                .balance(account.getBalance())
                .active(account.isActive())
                .alias(account.getAlias())
                .QR(account.getQR())
                .userName(account.getUser().getName())
                .cardNumber(userCard.getNumber())
                .cardExpiration(userCard.getExpiration())
                .cardIssuance(userCard.getIssuance())
                .cardCvv(userCard.getCVV())
                .cardActive(userCard.getActive())
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
