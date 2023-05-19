package com.transferTech.backend.service;

import com.transferTech.backend.dto.DepositRequestDto;
import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.MovementDto;
import com.transferTech.backend.dto.TransferRequestDto;
import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.Transfer;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.InputNotValidException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.MovementDtoMapper;
import com.transferTech.backend.repository.AccountRepository;
import com.transferTech.backend.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.constant.Constable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    private final MovementDtoMapper mapper;

    public MessageResponse transfer(Long senderAccountId, TransferRequestDto dto){

        Account sender = accountRepository.findById(senderAccountId)
                .orElseThrow(()-> new NotFoundException("Sender account not found"));
        Account receiver = accountRepository.findById(dto.getReceiverAccountId())
                .orElseThrow(()-> new NotFoundException("Receiver account not found"));

        if(sender.getBalance()<dto.getAmount()){
            throw new InputNotValidException("Insufficient Balance");
        }
        Transfer newTransfer = Transfer.builder()
                .senderAccount(sender)
                .receiverAccount(receiver)
                .amount(dto.getAmount())
                .dateTime(LocalDateTime.now())
                .transferCode(generateTransferCode())
                .description(dto.getDescription()).build();

        transferRepository.save(newTransfer);

        receiver.setBalance(receiver.getBalance()+dto.getAmount());
        sender.setBalance(sender.getBalance()-dto.getAmount());

        accountRepository.save(sender);
        accountRepository.save(receiver);

        return new MessageResponse(400,"Successful Transfer");
    }
    public MessageResponse deposit(Long accountId, DepositRequestDto dto){
        Account receiver = accountRepository.findById(accountId)
                .orElseThrow(()-> new NotFoundException("Receiver account not found"));

        Transfer newTransfer = Transfer.builder()
                .receiverAccount(receiver)
                .amount(dto.getAmount())
                .dateTime(LocalDateTime.now())
                .transferCode(generateTransferCode())
                .build();

        transferRepository.save(newTransfer);
        receiver.setBalance(receiver.getBalance()+dto.getAmount());
        accountRepository.save(receiver);

        return new MessageResponse(400,"Successful Deposit");
    };
    public Long generateTransferCode() {
        Random rand = new Random();
        return rand.nextLong(100000000,999999999);
    }

    public List<MovementDto> getAllMovementsById(Long id){
        return  transferRepository.getAllMovementsByUserId(id)
                .stream()
                .map(mapper::QueryResultRowToDto)
                .toList();

    }
}
