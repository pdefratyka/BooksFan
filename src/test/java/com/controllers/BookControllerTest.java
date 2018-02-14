package com.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.services.BookService;
import com.services.UserService;

public class BookControllerTest {

	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(bookController).build();
	}
	@Test
	public void trueIfBooksHref() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/books/")
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
