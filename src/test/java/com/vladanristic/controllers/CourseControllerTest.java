package com.vladanristic.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("Test")
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllCourses() throws Exception {
        mvc.perform(get("/courses/all")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}