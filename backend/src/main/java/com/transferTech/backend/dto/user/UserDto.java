package com.transferTech.backend.dto.user;

import com.transferTech.backend.entity.Account;
import com.transferTech.backend.entity.Role;
import com.transferTech.backend.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String dni;
    private String profileImg;
    private String dateOfBirth;
    private String phoneNumber;
    private List<Role> role;

}
