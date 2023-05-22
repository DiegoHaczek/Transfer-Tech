package com.transferTech.backend.service;

import com.transferTech.backend.dto.auth.AuthenticationRequestDto;
import com.transferTech.backend.dto.auth.AuthenticationResponseDto;
import com.transferTech.backend.dto.auth.RegisterRequestDto;
import com.transferTech.backend.entity.Profile;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.AlreadyExistException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.AuthDtoMapper;
import com.transferTech.backend.repository.ProfileRepository;
import com.transferTech.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AccountService accountService;
    private final AuthDtoMapper mapper;
    private final PasswordEncoder encoder;

    public AuthenticationResponseDto register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail().toLowerCase())){
            throw new AlreadyExistException("Error: Email already taken");
        }
        User newUser = mapper.requestToEntity(request);
        userRepository.save(newUser);
        Profile newProfile = new Profile(newUser);
        newUser.setAccount(accountService.createAccount(newUser));
        newUser.setProfile(profileRepository.save(newProfile));
        return new AuthenticationResponseDto("12345");
    }

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new NotFoundException("Email not found"));

        if(!encoder.matches(request.getPassword(),user.getPassword())){
            throw new NotFoundException("Wrong Password");
        }
        AuthenticationResponseDto authResponse = new AuthenticationResponseDto();
        authResponse.setToken("12345");
        return authResponse;
    }

}
