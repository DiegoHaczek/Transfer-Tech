package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.user.UserDto;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.utils.DateFormatter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@AllArgsConstructor
public class UserDtoMapper {

    private final DateFormatter formatter;

    public UserDto EntityToDto (User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .dateOfBirth(formatter.formatDate(user.getDateOfBirth()))
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .profileImg(user.getProfileImg())
                .dni(user.getDni())
                .role(user.getRole())
                .build();
    }



}
