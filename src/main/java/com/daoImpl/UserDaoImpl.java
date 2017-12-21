package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entities.Book;
import com.entities.User;
import com.entities.UserBook;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public User getUser(long id) {
		return null;
	}

	public User addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return null;
	}

	public User editUser(long id, User user) {
		return null;
	}

	public void deleteUser(long id) {
		
	}
	
	public boolean checkLogin(String login, String password) {

		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from User u where u.userName=? and u.userPassword=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, login);
		query.setParameter(1, password);
		if(query.list().size()>0)
			return true;
		else
			return false;
		
	}

	public long getUserId(String name) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from User u where u.userName=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0,name);
		User user=(User)query.list().get(0);
		
		return user.getId();
	}

	public List<Book> getReadBooks(long userId) {
		List<Book> list=new ArrayList<Book>();
		
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook u where u.userId=? and u.rate>?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, userId);
		query.setParameter(1, 0);
		List<UserBook> userBook=query.list();
		for(int i=0;i<userBook.size();i++){
			long bookId=userBook.get(i).getBookId();
			sqlQuery="from Book b where b.id=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, bookId);
			Book book=(Book)query.list().get(0);
			list.add(book);
		}
		return list;		
	}

	public List<Book> getWantToReadBooks(long userId) {
		List<Book> list=new ArrayList<Book>();
		
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook u where u.userId=? and u.wantToRead=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, userId);
		query.setParameter(1, 1);
		List<UserBook> userBook=query.list();
		for(int i=0;i<userBook.size();i++){
			long bookId=userBook.get(i).getBookId();
			sqlQuery="from Book b where b.id=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, bookId);
			Book book=(Book)query.list().get(0);
			list.add(book);
		}
		return list;		
	}
}
