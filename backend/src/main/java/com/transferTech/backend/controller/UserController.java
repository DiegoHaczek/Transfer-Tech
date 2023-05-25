package com.transferTech.backend.controller;

import com.transferTech.backend.dto.MessageResponse;
import com.transferTech.backend.dto.account.AccountInfoDto;
import com.transferTech.backend.repository.UserRepository;
import com.transferTech.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //TODO
    //create profile
    //edit profile
    //get By Role
    //assign role
    //delete role

    @PostMapping("/{userId}/contact")
    public ResponseEntity<MessageResponse> addContact
            (@PathVariable Long userId, @RequestBody Map<String,Long> contactId) {
            return  ResponseEntity.ok(userService.addContact(userId,contactId));
    }

    @DeleteMapping("/{userId}/contact")
    public ResponseEntity<MessageResponse> deleteContact
            (@PathVariable Long userId, @RequestBody Map<String,Long> contactId) {
        return  ResponseEntity.ok(userService.deleteContact(userId,contactId));
    }

    @GetMapping("/{userId}/contact")
    public ResponseEntity<List<AccountInfoDto>> getAllContacts
            (@PathVariable Long userId) {
        return  ResponseEntity.ok(userService.getAllContacts(userId));
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<MessageResponse> createProfile
            (@PathVariable Long userId, @RequestBody Map<String,Long> contactId) {
        return  ResponseEntity.ok(userService.addContact(userId,contactId));
    }

    @PutMapping("/{userId}/profile")
    public ResponseEntity<MessageResponse> editProfile
            (@PathVariable Long userId, @RequestBody Map<String,Long> contactId) {
        return  ResponseEntity.ok(userService.addContact(userId,contactId));
    }

}
