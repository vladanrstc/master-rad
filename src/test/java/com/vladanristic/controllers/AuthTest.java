package com.vladanristic.controllers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("Test")
@AutoConfigureMockMvc
class AuthTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllCourses() throws Exception {
        JSONObject j = new JSONObject();
        j.put("email", "superadmin@sample.com");
        j.put("password", "123123123");
        mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(buildUrlEncodedFormEntity(
                                "email", "superadmin@sample.com",
                                "password", "123123123"
                        )))
                .andExpect(status().isOk());
    }

    private String buildUrlEncodedFormEntity(String... params) {
        if( (params.length % 2) > 0 ) {
            throw new IllegalArgumentException("Need to give an even number of parameters");
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<params.length; i+=2) {
            if( i > 0 ) {
                result.append('&');
            }
            try {
                result.
                        append(URLEncoder.encode(params[i], StandardCharsets.UTF_8.name())).
                        append('=').
                        append(URLEncoder.encode(params[i+1], StandardCharsets.UTF_8.name()));
            }
            catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return result.toString();
    }
}