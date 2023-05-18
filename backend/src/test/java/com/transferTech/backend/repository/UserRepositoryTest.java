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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveNewUserAndFindItByEmail() {
        User newUser = User.builder()
                        .email("test2@example.com")
                        .password("password")
                        .build();

        entityManager.persistAndFlush(newUser);

        Optional<User> foundUser = userRepository.findByEmail("test2@example.com");

        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertEquals("test2@example.com", foundUser.get().getEmail());
    }

    @Test
    public void addNewContactAndCheckItsEmail() {
        User user1 = User.builder()
                .email("test3@example.com")
                .password("password")
                .contacts(new ArrayList<>())
                .build();

        entityManager.persistAndFlush(user1);

        User user2 = User.builder()
                .email("test4@example.com")
                .password("password")
                .build();

        entityManager.persistAndFlush(user2);

        user1.addContact(user2);
        entityManager.persistAndFlush(user1);

        Optional<User> findUser = userRepository.findByEmail("test3@example.com");

        Assertions.assertEquals("test4@example.com",findUser.get().getContacts().get(0).getEmail());
    }
}
