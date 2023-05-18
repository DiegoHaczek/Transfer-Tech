package com.transferTech.backend.controller;

import com.transferTech.backend.dto.AuthenticationRequestDto;
import com.transferTech.backend.dto.AuthenticationResponseDto;
import com.transferTech.backend.dto.RegisterRequestDto;
import com.transferTech.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.JMXAuthenticator;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

    public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid
                                          RegisterRequestDto request) {
        AuthenticationResponseDto registerResponse = authService.register(request);
        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticateUser(
            @RequestBody AuthenticationRequestDto request) {
        AuthenticationResponseDto authResponse = authService.authenticate(request);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
