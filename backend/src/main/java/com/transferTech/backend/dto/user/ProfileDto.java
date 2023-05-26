package com.transferTech.backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class ProfileDto {

    @NotNull(message = "Dni can't be null")
    @Pattern(regexp = "^\\d{1,3}\\./?\\d{3}\\./?\\d{3}$",
            message = "Invalid Dni format")
    private String dni;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^([a-zA-Zñ ]){1,20}$",
            message = "Name must contain only letters and spaces and be maximum 20 characters")
    private String name;

    @NotNull(message = "Date of birth is required")
    //@DateTimeFormat(pattern="dd/MM/yyyy")
    private Date date_of_birth;


}
