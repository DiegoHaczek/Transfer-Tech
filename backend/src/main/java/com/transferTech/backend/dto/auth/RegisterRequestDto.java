package com.transferTech.backend.dto.auth;

import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank(message = "Email is required")
    @Email (regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Email direction isn't valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^([a-zA-Z0-9,ñ]){8,20}$",
            message = "Password must contain at least 8 characters including letters, numbers, spaces and commas")
    private String password;
}
