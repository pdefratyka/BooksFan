package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.DatabaseService;


@Controller
public class DatabaseController {
	@Autowired
	private DatabaseService databaseService;
	private static String url="/BX-Books.csv";

	
	/*@RequestMapping("/database")
	public String createDatabase(Model model) {
		if(databaseService.databaseIsEmpty())
			databaseService.createDatabase(url);
		return "home";
	}*/ 
}
