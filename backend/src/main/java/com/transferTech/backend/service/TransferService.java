package com.transferTech.backend.service;

import com.transferTech.backend.dto.movement.DepositRequestDto;
import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.movement.MovementDto;
import com.transferTech.backend.dto.movement.TransferRequestDto;
import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.Transfer;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.InputNotValidException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.MovementDtoMapper;
import com.transferTech.backend.repository.AccountRepository;
import com.transferTech.backend.repository.TransferRepository;
import com.transferTech.backend.utils.StringFormatter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    private final MovementDtoMapper mapper;
    private final StringFormatter formatter;

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
                .description(formatter.formatString(dto.getDescription()))
                .build();

        updateBalances(newTransfer,receiver,sender);

        return new MessageResponse(200,"Successful Transfer");
    }
    @Transactional
    public void updateBalances(Transfer transfer, Account receiver, Account sender) {
        transferRepository.save(transfer);
        receiver.addBalance(transfer.getAmount());
        sender.subtractBalance(transfer.getAmount());
        accountRepository.save(receiver);
        accountRepository.save(sender);
    }
    public MessageResponse deposit(Long accountId, DepositRequestDto dto){
        Account receiver = accountRepository.findById(accountId)
                .orElseThrow(()-> new NotFoundException("Receiver account not found"));

        Transfer newDeposit = Transfer.builder()
                .receiverAccount(receiver)
                .amount(dto.getAmount())
                .dateTime(LocalDateTime.now())
                .transferCode(generateTransferCode())
                .build();

        updateBalance(newDeposit,receiver);

        return new MessageResponse(200,"Successful Deposit");
    }
    @Transactional
    public void updateBalance(Transfer deposit, Account receiver) {
        transferRepository.save(deposit);
        receiver.addBalance(deposit.getAmount());
        accountRepository.save(receiver);
    }
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
