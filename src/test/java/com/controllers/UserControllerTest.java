package com.controllers;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert.*;
import com.services.UserService;
import com.servicesImpl.UserServiceImpl;

import javassist.NotFoundException;

import org.mockito.Mockito.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebAppConfiguration
public class UserControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	
	@Test
	public void trueIfUsersReturnOk() throws Exception {
		//when(userService.getUser(121L)).thenThrow(new NotFoundException(""));
		mockMvc.perform(
				MockMvcRequestBuilders.get("/users/102")
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
        //verify(userService, times(1)).getUser(1L);
        //verifyNoMoreInteractions(userService);
		//assertEquals(userService.getUser(1L).getUserName(),"Marcin27");
		
	}

}
