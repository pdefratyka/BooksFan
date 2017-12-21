package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.entities.Book;

@Controller
public class HomeController extends WebMvcConfigurerAdapter{

	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("books/{id}")
	public String particularBook(@PathVariable("id") long id){
		return "particularBook";
	}
	@RequestMapping("/ranking")
	public String ranking(){
		return "ranking";
	}
	@RequestMapping("/recentlyread")
	public String recentlyRead(){
		return "recentlyRead";
	}
	@RequestMapping("/articles/{header}")
	public String article(@PathVariable("header") String header){
		return "article";
	}

}
