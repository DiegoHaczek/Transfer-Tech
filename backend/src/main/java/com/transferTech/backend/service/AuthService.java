package com.transferTech.backend.service;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.auth.ApprovalRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationResponseDto;
import com.transferTech.backend.dto.auth.RegisterRequestDto;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.AlreadyExistException;
import com.transferTech.backend.exception.ForbiddenException;
import com.transferTech.backend.exception.InputNotValidException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.AuthDtoMapper;
import com.transferTech.backend.repository.UserRepository;
import com.transferTech.backend.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final RekognitionService rekognitionService;
    private final EmailService emailService;
    private final AuthDtoMapper mapper;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Map<String, String> register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail().toLowerCase())) {
            throw new AlreadyExistException("Error: Email already taken");
        }
        User newUser = mapper.requestToEntity(request);
        newUser = userRepository.save(newUser);

        Long verificationCode = generateVerificationCode();
        emailService.sendVerificationEmail(newUser.getEmail(),verificationCode);

        String jwtToken = jwtService.generateToken(newUser);
        Map<String, String> response = new HashMap<>();
        response.put("user_id", String.valueOf(newUser.getId()));
        response.put("verification_code", String.valueOf(verificationCode));
        response.put("token",jwtToken);
        return response;
    }
    public Long generateVerificationCode() {
        Random rand = new Random();
        return rand.nextLong(100000,999999);
    }
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Error: Username not found"));
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new NotFoundException("Wrong Password");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponseDto authResponse = new AuthenticationResponseDto();
        authResponse.setToken(jwtToken);
        return authResponse;
    }
    public MessageResponse checkApprovalRequest(Long userId, ApprovalRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("User not found"));

        if (Objects.equals(user.getName(),null)){
            throw new ForbiddenException("User must complete his profile first");
        }

        if (accountService.userHasAnAccount(userId)){
            throw new ForbiddenException("User is already verified and has an associated account");
        };

        try {
            rekognitionService.verifyIdentity(request);
        }catch (IOException e){
            throw new InputNotValidException("There was a problem processing the provided images");
        }

        user.setAccount(accountService.createAccount(user));
        Long accountId = user.getAccount().getId();

        return new MessageResponse(200,
                "Documentation is valid. Created account id: " + accountId);
    }

}
