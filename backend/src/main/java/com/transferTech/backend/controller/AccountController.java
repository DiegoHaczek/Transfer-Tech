package com.transferTech.backend.controller;

import com.transferTech.backend.dto.*;
import com.transferTech.backend.service.AccountService;
import com.transferTech.backend.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final TransferService transferService;

    //TODO
    //getById
    //getByAlias
    //getByAccountNumber
    //getAll
    //getAll movements By Id
    //deleteAccount

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
