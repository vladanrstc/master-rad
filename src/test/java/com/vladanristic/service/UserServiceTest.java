package com.vladanristic.service;

import com.vladanristic.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

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