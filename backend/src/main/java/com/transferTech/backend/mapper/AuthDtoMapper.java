package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.auth.RegisterRequestDto;
import com.transferTech.backend.entity.Role;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.enumeration.ERole;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthDtoMapper {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User requestToEntity(RegisterRequestDto registerRequestDto){
        List<Role> roles = List.of(roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(()-> new NotFoundException("Role USER not found")));

        return User.builder()
                .email(registerRequestDto.getEmail().toLowerCase())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .role(roles)
                .build();
    }

}