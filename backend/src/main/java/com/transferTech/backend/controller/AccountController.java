package com.transferTech.backend.controller;

import com.transferTech.backend.dto.*;
import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.account.AccountResponseDto;
import com.transferTech.backend.dto.movement.DepositRequestDto;
import com.transferTech.backend.dto.movement.MovementDto;
import com.transferTech.backend.dto.movement.TransferRequestDto;
import com.transferTech.backend.service.AccountService;
import com.transferTech.backend.service.CardService;
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
    private final CardService cardService;

    @GetMapping("")
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> getAccountById(
            @PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.getById(accountId),HttpStatus.OK);
    }

    @PostMapping("/info/alias")
    public ResponseEntity<AccountInfoDto> getAccountInfoByAlias(
            @RequestBody Map<String,String> alias) {
        return new ResponseEntity<>(accountService.getAccountInfoByAlias(
                alias.getOrDefault("alias","")),HttpStatus.OK);
    }

    @PostMapping("/info/account_number")
    public ResponseEntity<AccountInfoDto> getAccountInfoByAccountNumber(
            @RequestBody Map<String,String> alias) {
        return new ResponseEntity<>(accountService.getAccountInfoByAccountNumber(
                alias.getOrDefault("account_number","1")),HttpStatus.OK);
    }

    @PostMapping("/{accountId}/transfer")
    public ResponseEntity<MessageResponse> transfer(
            @RequestBody @Valid TransferRequestDto request, @PathVariable Long accountId) {
        return new ResponseEntity<>(transferService.transfer(accountId,request),HttpStatus.OK);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<MessageResponse> deposit(
            @RequestBody @Valid DepositRequestDto request, @PathVariable Long accountId) {
        return new ResponseEntity<>(transferService.deposit(accountId,request), HttpStatus.OK);
    }

    @GetMapping("/{accountId}/movements")
    public ResponseEntity<List<MovementDto>> getMovementsById(@PathVariable Long accountId) {
        return new ResponseEntity<>(transferService.getAllMovementsById(accountId),HttpStatus.OK);
    }

    @PutMapping("/{accountId}/deactivate")
    public ResponseEntity<MessageResponse> deactivate(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.deactivateAccount(accountId),HttpStatus.OK);
    }

    @PutMapping("/{accountId}/deactivate_card")
    public ResponseEntity<MessageResponse> deactivateCard(@PathVariable Long accountId) {
        return new ResponseEntity<>(cardService.deactivateCard(accountId),HttpStatus.OK);
    }

    @PutMapping("/{accountId}/activate_card")
    public ResponseEntity<MessageResponse> activateCard(@PathVariable Long accountId) {
        return new ResponseEntity<>(cardService.activateCard(accountId),HttpStatus.OK);
    }
}
