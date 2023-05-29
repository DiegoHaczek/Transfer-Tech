package com.transferTech.backend.service;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.auth.ApprovalRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationResponseDto;
import com.transferTech.backend.dto.auth.RegisterRequestDto;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.AlreadyExistException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.AuthDtoMapper;
import com.transferTech.backend.repository.UserRepository;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final EmailService emailService;
    private final AuthDtoMapper mapper;
    private final PasswordEncoder encoder;

    public Map<String, Long> register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail().toLowerCase())) {
            throw new AlreadyExistException("Error: Email already taken");
        }
        User newUser = mapper.requestToEntity(request);
        newUser = userRepository.save(newUser);
        Long verificationCode = generateVerificationCode();
        emailService.sendVerificationEmail(newUser.getEmail(),verificationCode);
        //newUser.setAccount(accountService.createAccount(newUser));
        Map<String, Long> response = new HashMap<>();
        response.put("user_id", newUser.getId());
        response.put("verification_code", verificationCode);
        return response;
        //return new AuthenticationResponseDto("12345");
    }

    public Long generateVerificationCode() {
        Random rand = new Random();
        return rand.nextLong(100000,999999);
    }
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new NotFoundException("Email not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new NotFoundException("Wrong Password");
        }
        AuthenticationResponseDto authResponse = new AuthenticationResponseDto();
        authResponse.setToken("12345");
        return authResponse;
    }
    public MessageResponse checkApprovalRequest(Long userId, ApprovalRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("User not found"));

        user.setAccount(accountService.createAccount(user));
        Long accountId = user.getAccount().getId();

        return new MessageResponse(400,
                "Documentation is valid. Created account id: " + accountId);
    }
}
