package com.transferTech.backend.service;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.user.ProfileDto;
import com.transferTech.backend.dto.user.UserDto;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.mapper.AccountDtoMapper;
import com.transferTech.backend.mapper.UserDtoMapper;
import com.transferTech.backend.repository.UserRepository;
import com.transferTech.backend.utils.StringFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper userMapper;
    private final AccountDtoMapper accountMapper;
    private final StringFormatter formatter;

    public MessageResponse addContact(Long userId, Map<String, Long> contactId) {
        User user = retrieveUser(userId);
        User contact = retrieveUser(contactId.getOrDefault("contact_id",0L));

        user.addContact(contact);
        userRepository.save(user);

        return new MessageResponse(400,"Contact added successfully");
    }
    public MessageResponse deleteContact(Long userId, Map<String, Long> contactId) {
        User user = retrieveUser(userId);
        User contact = retrieveUser(contactId.getOrDefault("contact_id",0L));

        user.deleteContact(contact);
        userRepository.save(user);

        return new MessageResponse(400,"Contact deleted successfully");
    }
    private User retrieveUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("User not found."));
    }
    public List<AccountInfoDto> getAllContacts(Long userId) {
        return  userRepository.getAllContactsByUserId(userId)
                .stream()
                .map(accountMapper::QueryResultRowToDto)
                .toList();
    }
    public MessageResponse createProfile(Long userId, ProfileDto profileDto) {
        User user = retrieveUser(userId);

        user.setName(formatter.formatName(profileDto.getName()));
        user.setDateOfBirth(profileDto.getDate_of_birth());
        user.setDni(profileDto.getDni());

        userRepository.save(user);

        return new MessageResponse(400,"Profile created successfully");
    }
    public UserDto getById(Long userId) {
        return userMapper.EntityToDto(retrieveUser(userId));
    }
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::EntityToDto)
                .toList();
    }
}
