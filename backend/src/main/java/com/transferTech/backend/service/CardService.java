package com.transferTech.backend.service;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.entity.Card;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/yy");

    public void generateCreditCard(User user) {
        LocalDateTime currentDate = LocalDateTime.now();
        Random rand = new Random();
        int validityYears = 6;
        int validityMonths = 1;

        Card newCreditCard = Card.builder()
                .user(user)
                .id(user.getId())
                .number(generateCreditCardNumber())
                .issuance(currentDate.format(dateFormatter))
                .expiration(currentDate.plusYears(validityYears).plusMonths(validityMonths).format(dateFormatter))
                .CVV(rand.nextInt(100,999))
                .active(true)
                .build();

        cardRepository.save(newCreditCard);
    }

    public MessageResponse deactivateCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(
                ()-> new NotFoundException("Card not found"));

        card.deactivate();
        return new MessageResponse(200,"Card deactivated");
    }

    public MessageResponse activateCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(
                ()-> new NotFoundException("Card not found"));

        card.deactivate();
        return new MessageResponse(200,"Card activated");
    }

    public BigInteger generateCreditCardNumber(){
        BigInteger maxLimit = new BigInteger("9999999999999990");
        BigInteger minLimit = new BigInteger("1000000000000000");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);
        return res;
    }
}
