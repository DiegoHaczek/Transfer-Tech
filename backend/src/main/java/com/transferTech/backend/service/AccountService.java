package com.transferTech.backend.service;

import com.google.zxing.WriterException;
import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.account.AccountResponseDto;
import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.Card;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.ForbiddenException;
import com.transferTech.backend.exception.InputNotValidException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.AccountDtoMapper;
import com.transferTech.backend.repository.AccountRepository;
import com.transferTech.backend.utils.QrGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CardService cardService;
    private final AccountDtoMapper mapper;

    public Account createAccount(User user){
        if (userHasAnAccount(user.getId())){
            throw new ForbiddenException("User is already verified and has an associated account");
        }
        Account newAccount =  Account.builder()
                .id(user.getId())
                .user(user)
                .accountNumber(generateAccountNumber())
                .alias(generateAlias())
                .QR(QrGenerator.generateQr(user.getId()))
                .balance(0.0)
                .active(true)
                .build();

        accountRepository.save(newAccount);
        cardService.generateCreditCard(user);

        return newAccount;
    }
    public boolean userHasAnAccount(Long userId){
        return accountRepository.existsByUserId(userId);
    }
    public BigInteger generateAccountNumber() {
        int bankID = 132;
        int subsidiaryId = 1050;
        BigInteger maxLimit = new BigInteger("999999999999999");
        BigInteger minLimit = new BigInteger("100000000000000");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);
        BigInteger accountNumber = new BigInteger(bankID
                + String.valueOf(subsidiaryId)
                + res
        );
        if (accountRepository.existsByAccountNumber(accountNumber)){
            accountNumber = generateAccountNumber();
        }
        return accountNumber;
    }
    public String generateAlias() {
        List<String> words = new ArrayList<>(List.of("casa", "mesa", "silla", "almohada",
                "perro", "gato", "leon", "pieza", "armario", "cuna", "rata", "porton", "hueco",
                "noche", "dia", "mientras", "manija", "diurno", "paz", "sueño", "planta",
                "helicoptero", "raton", "ante", "contra", "guitarra", "bajo", "picante",
                "suciedad", "limpio", "arroz", "camello","luz","heladera","ciudad",
                "amigo","hora"));

        Collections.shuffle(words);

        Optional<String> alias = words.stream()
                .limit(3).
                reduce((res,e) -> res.concat("."+e));

        if(accountRepository.existsByAlias(alias.get())){
            alias = Optional.of(generateAlias());
        }

        return alias.get();
    }
    public AccountResponseDto getById(Long accountId) {
        return mapper.EntityToDto(accountRepository.findById(accountId)
                .orElseThrow(()-> new NotFoundException("Account not found")));
    }
    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(mapper::EntityToDto)
                .toList();
    }
    public AccountInfoDto getAccountInfoByAlias(String alias) {
        Account account = accountRepository.findByAlias(alias).orElseThrow(()->
                new NotFoundException("Account not found"));
        return mapper.EntityToInfoDto(account);
    }
    public AccountInfoDto getAccountInfoByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(new BigInteger(accountNumber))
                .orElseThrow(()-> new NotFoundException("Account not found"));
        return mapper.EntityToInfoDto(account);
    }
    public MessageResponse deactivateAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(()-> new NotFoundException("Account not found"));
        if (!account.isActive()){
            throw new InputNotValidException("The account is already inactive");
        }
        account.deactive();
        return new MessageResponse(200,"The account is now inactive");
    }
}
