package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Book;
import com.entities.User;
import com.services.UserService;

@Controller
@RequestMapping("/users")
@SessionAttributes({"name", "userId"})
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getUser(@PathVariable("id") long id){
		return userService.getUser(id);
	}
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User addUser(@RequestBody User user){
		userService.addUser(user);
		return user;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public User editUser(@RequestBody User user, @PathVariable("id")long id){
		return userService.editUser(id, user);
	}
	@RequestMapping(value="{/id}", method=RequestMethod.DELETE)
	@ResponseBody//I think this is not necessary
	public void deleteUser(@PathVariable("id")long id){
		userService.deleteUser(id);
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkLogin(@RequestParam("login") String login, @RequestParam("password") String password, ModelMap model){
		boolean check=userService.checkLogin(login, password);
		long id=userService.getUserId(login);
		if(check){
			model.put("name",login);
			model.put("userId",id);
		}
		return check;
	}
	@RequestMapping(value="/logout", method=RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void logout(HttpSession session, SessionStatus status){
	       status.setComplete();
	       session.removeAttribute("name");
	       session.removeAttribute("userId");
	}
	//It didn't work until I add @ResponseBody annotation. In Ajax also has to be some ContentType.
	@RequestMapping("/{id}")
	public String profile(){
		return "profile";
	}
	@RequestMapping(value="/{id}/books", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Book> getReadBooks(@PathVariable("id") long userId){
		return userService.getReadBooks(userId);
	}
	@RequestMapping(value="/{id}/wantread", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Book> getWantToReadBooks(@PathVariable("id") long userId){
		return userService.getWantToReadBooks(userId);
	}
	@RequestMapping(value="/{id}/addbook")
	public String addBook(){
		return "addBook";
	}
}
