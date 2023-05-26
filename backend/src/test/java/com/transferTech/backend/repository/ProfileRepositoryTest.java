package com.transferTech.backend.repository;

import com.transferTech.backend.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        userRepository.saveAndFlush(
                User.builder()
                        .email("test2@example.com")
                        .password("example")
                        .name("John Doe")
                        .build()
        );
    }

    @Test
    void addProfileToUser() {
        profileRepository.saveAndFlush(
                Profile.builder()
                        .user(userRepository.findByEmail("test2@example.com").get())
                        .dateOfBirth(new Date(14-6-1996))
                        .country("Argentina")
                        .city("Buenos Aires")
                        .zipCode(7100)
                        .profileImg(null)
                        .build()
        );

        Optional<Profile> newProfile = profileRepository.findById(1L);
        Optional<User> user = userRepository.findByEmail("test2@example.com");

        user.get().setProfile(newProfile.get());
        userRepository.saveAndFlush(user.get());

        Assertions.assertEquals(user.get().getProfile(),newProfile.get());
    }
}
