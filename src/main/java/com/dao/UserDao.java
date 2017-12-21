package com.dao;

import java.util.List;

import com.entities.Book;
import com.entities.User;


public interface UserDao {
	/*POST, PUT, DELETE*/
	public User addUser(User user);
	public User editUser(long id, User user);
	public void deleteUser(long id);
	public User getUser(long id);
	/*GET*/
	public boolean checkLogin(String login, String password);
	public long getUserId(String login);
	public List<Book>getReadBooks(long userId);
	public List<Book>getWantToReadBooks(long userId);

}
