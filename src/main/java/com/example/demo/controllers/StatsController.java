package com.example.demo.controllers;

import com.example.demo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public Map<String, Long> getAppStats() {
        return this.statsService.getAppStats();
    }

}
