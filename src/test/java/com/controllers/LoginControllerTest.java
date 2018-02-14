package com.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.services.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebAppConfiguration
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(loginController).build();
	}
	@Test
	public void trueIfLoginReturnsOk() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/login")
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void trueIfRegisternReturnsOk() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/register")
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
