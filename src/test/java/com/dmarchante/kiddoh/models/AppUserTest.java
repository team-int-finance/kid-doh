package com.dmarchante.kiddoh.models;

import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class AppUserTest {
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testUserCreation(){
        AppUser testUser = new AppUser("user", "user");
        assertTrue(testUser instanceof AppUser);
    }

    @Test
    public void test_getUsername() {
        AppUser testUser = new AppUser("user", "user");
        assertTrue(testUser.getUsername().equals("user"));
    }

}