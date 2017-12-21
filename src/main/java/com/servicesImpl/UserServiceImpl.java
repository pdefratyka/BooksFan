package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DatabaseDao;
import com.dao.UserDao;
import com.entities.Book;
import com.entities.User;
import com.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return this.userDao;
	}
	@Transactional
	public User getUser(long id) {
		return userDao.getUser(id);
	}
	@Transactional
	public User addUser(User user) {
		return userDao.addUser(user);
	}
	@Transactional
	public User editUser(long id, User user) {
		return userDao.editUser(id, user);
	}
	@Transactional
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}
	@Transactional
	public boolean checkLogin(String login, String password) {
		return userDao.checkLogin(login, password);
	}
	@Transactional
	public long getUserId(String login) {
		return userDao.getUserId(login);
	}
	@Transactional
	public List<Book> getReadBooks(long userId) {
		return userDao.getReadBooks(userId);
	}
	@Transactional
	public List<Book> getWantToReadBooks(long userId) {
		return userDao.getWantToReadBooks(userId);
	}

}
