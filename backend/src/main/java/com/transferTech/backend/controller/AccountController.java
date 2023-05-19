package com.transferTech.backend.controller;

import com.transferTech.backend.dto.*;
import com.transferTech.backend.service.AccountService;
import com.transferTech.backend.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final TransferService transferService;

    //TODO
    //getById
    //getAll movements By Id
    //deleteAccount
    @GetMapping("/movements/{userId}")
    public ResponseEntity<List<MovementDto>> getMovementsById(@PathVariable Long userId) {
        return new ResponseEntity<>(transferService.getAllMovementsById(userId),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping("/info/alias")
    public ResponseEntity<AccountInfoDto> getAccountInfoByAlias(
            @RequestBody Map<String,String> alias) {
        return new ResponseEntity<>(accountService.getAccountInfoByAlias(
                alias.getOrDefault("alias","")),HttpStatus.OK);
    }

    @GetMapping("/info/account_number")
    public ResponseEntity<AccountInfoDto> getAccountInfoByAccountNumber(
            @RequestBody Map<String,String> alias) {
        return new ResponseEntity<>(accountService.getAccountInfoByAccountNumber(
                alias.getOrDefault("account_number","1")),HttpStatus.OK);
    }

    @PostMapping("{accountId}/transfer")
    public ResponseEntity<MessageResponse> transfer(
            @RequestBody @Valid TransferRequestDto request, @PathVariable Long accountId) {
        return new ResponseEntity<>(transferService.transfer(accountId,request),HttpStatus.OK);
    }

    @PostMapping("{accountId}/deposit")
    public ResponseEntity<MessageResponse> deposit(
            @RequestBody @Valid DepositRequestDto request,@PathVariable Long accountId) {
        return new ResponseEntity<>(transferService.deposit(accountId,request), HttpStatus.OK);
    }
}
