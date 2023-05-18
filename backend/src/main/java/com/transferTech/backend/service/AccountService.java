package com.transferTech.backend.service;

import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(User user){
        Account newAccount =  Account.builder()
                .user(user)
                .accountNumber(generateAccountNumber())
                .alias(generateAlias())
                .QR(generateQR())
                .balance(0.0)
                .active(true)
                .build();

        accountRepository.save(newAccount);
        return newAccount;
    }

    public BigInteger generateAccountNumber(){
        BigInteger maxLimit = new BigInteger("9999999999999999999999");
        BigInteger minLimit = new BigInteger("1000000000000000000000");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);

        if (accountRepository.existsByAccountNumber(res)){
            res = generateAccountNumber();
        }
        return res;
    }

    public String generateAlias(){
        List<String> words = new ArrayList<>(List.of("casa", "mesa", "silla", "almohada", "perro", "gato", "leon",
                "pieza", "armario", "cuna", "rata", "porton", "hueco", "noche", "dia", "mientras",
                "manija", "diurno", "paz", "sueño", "planta", "helicoptero", "raton", "ante", "contra",
                "guitarra", "bajo", "picante", "suciedad", "limpio", "arroz", "camello"));

        Collections.shuffle(words);

        Optional<String> alias = words.stream()
                .limit(3).
                reduce((res,e) -> res.concat("."+e));

        if(accountRepository.existsByAlias(alias.get())){
            alias = Optional.of(generateAlias());
        }

        return alias.get();
    }

    public String generateQR(){
        return "";
    }
}
