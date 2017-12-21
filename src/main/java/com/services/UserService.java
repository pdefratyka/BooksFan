package com.services;

import java.util.List;

import com.entities.Book;
import com.entities.User;

public interface UserService {
	/*POST, PUT, DELETE*/
	public User addUser(User user);
	public User editUser(long id, User user);
	public void deleteUser(long id);
	/*GET*/
	public User getUser(long id);
	public boolean checkLogin(String login, String password);
	public long getUserId(String login);
	public List<Book>getReadBooks(long userId);
	public List<Book>getWantToReadBooks(long userId);

}
