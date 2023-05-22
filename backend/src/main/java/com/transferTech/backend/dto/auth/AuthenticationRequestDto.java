package com.transferTech.backend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthenticationRequestDto {
    @NotBlank(message = "Email can't be empty")
    String email;
    @NotBlank(message = "Password can't be empty")
    String password;
}
