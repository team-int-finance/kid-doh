package com.dmarchante.kiddoh;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import com.dmarchante.kiddoh.repositories.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ContextConfiguration
public class KidDohApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/templates/");
		viewResolver.setSuffix("*.html");

		return viewResolver;
	}

	@Before
	public void setup() {
		MockServletContext servletContext = (MockServletContext) context.getServletContext();
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Autowired
	AppUserRepo appUserRepo;

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	TransactionRepository transactionRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHomeRoute() throws Exception {
		mockMvc.perform(get("/login")).andExpect(content().string(containsString("K")));
	}

	@Test
	public void test_signUp() throws Exception {
		mockMvc.perform(get("/signup")).andExpect(content().string(containsString("Re-Enter")));
	}


	public static RequestPostProcessor testUser(){
		return user("user1").password("password").roles("ADMIN");
	}


	//suggested to help with other integration tests.
//	public static RequestPostProcessor testUser1(){
//		return user("user1").password("password").authorities(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				return "role_admin";
//			}
//		});
//	}

	@WithMockUser
	@Test
	public void testIntegrationAddAccount() throws Exception{
		mockMvc.perform(get("/account/add").with(testUser1())).andExpect(content().string(containsString("Dashboard")));
	}

//	@WithMockUser
//	@Test
//	public void testIntegrationMyAccounts() throws Exception{
//		mockMvc.perform(get("/myAccounts").with(testUser1())).andExpect(content().string(containsString("account")));
//	}

}
