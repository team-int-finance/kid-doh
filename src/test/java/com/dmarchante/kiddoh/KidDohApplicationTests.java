package com.dmarchante.kiddoh;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KidDohApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	AppUserRepo appUserRepo;



	@Test
	public void contextLoads() {
	}

	@Test
	public void testHomeRoute() throws Exception {
		mockMvc.perform(get("/")).andExpect(content().string(containsString("Kid-Doh")));
	}

	@Test
	public void test_signUp() throws Exception {
		mockMvc.perform(get("/signup")).andExpect(content().string(containsString("Page")));
	}



}
