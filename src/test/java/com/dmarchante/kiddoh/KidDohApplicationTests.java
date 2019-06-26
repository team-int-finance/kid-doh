package com.dmarchante.kiddoh;

import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = KidDohApplication.class)
@SpringBootTest
//@WebMvcTest
@AutoConfigureMockMvc
public class KidDohApplicationTests {

	@Autowired
	MockMvc mockMvc;

//	@Autowired
//	WebApplicationContext webApplicationContext;

	@Autowired
	AppUserRepo appUserRepo;

//	@Before
//	public void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}

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

//	@Test
//	@WithMockUser
//	public void testLoggedIn() throws Exception {
////		RequestBuilder rb = post("/login")
////				.param("username", "user1")
////				.param("password", "password");
////		mockMvc.perform(rb).andExpect((content().string(containsString("Kid-doh Accounts"))));
//		mockMvc.perform(get("/myAccount")).andExpect((content().string(containsString("Kid-doh Accounts"))));
//	}

}
