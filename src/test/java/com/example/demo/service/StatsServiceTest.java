package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("Test")
class StatsServiceTest {

    @Autowired
    private StatsService statsService;

    @Test
    void getAppStats() {

        Assertions.assertThat(statsService.getAppStats().values().size()).isEqualTo(6);

    }
}