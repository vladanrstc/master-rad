package com.example.demo.service;

import com.example.demo.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("Test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void unbanUser() {
        List<User> users = userService.getUsers();
        Random random = new Random();
        int r = random.nextInt(users.size() - 1);
        User randomUser = users.get(r);
        userService.unbanUser(randomUser.getId());
        Assertions.assertThat(randomUser.getDeletedAt()).isNull();
    }

    @Test
    void loadUserByUsername() {
        Assertions.assertThat(userService.loadUserByUsername("superadmin@sample.com")).isNotNull();
    }
}