package com.vladanristic.controllers;

import com.vladanristic.dtos.LessonEntity;
import com.vladanristic.service.LessonService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("Test")
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HomeController homeController;

    @Autowired
    private LessonService lessonService;

    @Test
    void homeVideos() throws Exception {
        List<LessonEntity> lessons = this.lessonService.getLastThreeVideos();
        ResponseEntity response = new ResponseEntity(lessons, HttpStatus.OK);
        BDDMockito.given(homeController.homeVideos()).willReturn(response);
        mvc.perform(get("/home/videos")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}