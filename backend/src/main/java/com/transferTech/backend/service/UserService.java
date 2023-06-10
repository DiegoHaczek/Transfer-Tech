package com.transferTech.backend.service;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.dto.user.ProfileDto;
import com.transferTech.backend.dto.user.UserDto;
import com.transferTech.backend.entity.Role;
import com.transferTech.backend.entity.User;
import com.transferTech.backend.enumeration.ERole;
import com.transferTech.backend.exception.ForbiddenException;
import com.transferTech.backend.exception.NotFoundException;
import com.transferTech.backend.exception.SqlConstraintException;
import com.transferTech.backend.mapper.AccountDtoMapper;
import com.transferTech.backend.mapper.UserDtoMapper;
import com.transferTech.backend.repository.RoleRepository;
import com.transferTech.backend.repository.UserRepository;
import com.transferTech.backend.utils.StringFormatter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserDtoMapper userMapper;
    private final AccountDtoMapper accountMapper;
    private final StringFormatter formatter;

    public MessageResponse addContact(Long userId, Map<String, Long> contactId) {
        User user = retrieveUser(userId);
        User contact = retrieveUser(contactId.getOrDefault("contact_id",0L));

        user.addContact(contact);
        userRepository.save(user);

        return new MessageResponse(200,"Contact added successfully");
    }
    public MessageResponse deleteContact(Long userId, Map<String, Long> contactId) {
        User user = retrieveUser(userId);
        User contact = retrieveUser(contactId.getOrDefault("contact_id",0L));

        user.deleteContact(contact);
        userRepository.save(user);

        return new MessageResponse(200,"Contact deleted successfully");
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

        try {
            userRepository.save(user);
        }catch (RuntimeException e){
            throw new SqlConstraintException("Dni is already associated with another user");
        }

        return new MessageResponse(200,"Profile created successfully");
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

    @Transactional
    public UserDto updateRole(Long id, String requestRole) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Error: User not found"));
        if (user.getRole().contains(roleRepository.findByName(ERole.ROLE_ADMIN).get()))
            throw new ForbiddenException("Error: Cant change admin role");

        Role role = roleRepository.findByName(Role.RoletoERole(requestRole))
                .orElseThrow(() -> new NotFoundException("Error: Role not found."));
        user.getRole().clear();
        user.getRole().add(role);
        userRepository.save(user);
        return userMapper.EntityToDto(user);
    }
}
