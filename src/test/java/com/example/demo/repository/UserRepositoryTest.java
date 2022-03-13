package com.example.demo.repository;

import com.example.demo.entities.User;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldFindByEmail() {
        Assertions.assertThat(userRepository.getById(2L)).isNotNull();
    }

    @Test
    void itShouldSaveAUser() {
        Random rand = new Random();
        int n = rand.nextInt(50000);

        User newUser = new User();
        newUser.setName("Test Name");
        newUser.setLastName("Test Last Name");
        newUser.setEmail("email" + n + "@sample.com");
        newUser.setRole("USER");
        newUser.setPassword("testPassword");

        User createdUser = userRepository.save(newUser);

        Assertions.assertThat(createdUser).isNotNull();

    }

}