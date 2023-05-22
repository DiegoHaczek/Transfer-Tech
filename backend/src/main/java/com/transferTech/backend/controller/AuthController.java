package com.transferTech.backend.controller;

import com.transferTech.backend.dto.auth.AuthenticationRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationResponseDto;
import com.transferTech.backend.dto.auth.RegisterRequestDto;
import com.transferTech.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

    public class AuthController {

    private final AuthService authService;

    //TODO
    //check Approval Request

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
