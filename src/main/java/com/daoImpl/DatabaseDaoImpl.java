package com.daoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.dao.DatabaseDao;
import com.entities.Book;

@Repository("databaseDao")
public class DatabaseDaoImpl implements DatabaseDao {

	@SuppressWarnings("restriction")
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private static Scanner scanner;
	private static InputStream inputStream;
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void createDatabase(String url) {
		openFile(url);
		saveFile();
		closeDatabase();
	}
	
	private void openFile(String url) {
		inputStream = getClass().getResourceAsStream(url);
		scanner = new Scanner(inputStream);
		scanner.useDelimiter(";");
	}
	
	private void saveFile() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int record;
		int correct = 0;
		for (record = 0; record < 210000; record++) {
			scanner.next();
			String title = scanner.next();
			if (title.length() < 60)
				correct++;
			String autor = scanner.next();
			if (autor.length() < 60)
				correct++;
			String year = scanner.next();
			scanner.next();
			String s = scanner.next();
			String m = scanner.next();
			String l = scanner.next();
			System.out.println(title + " " + autor + " " + year + " " + s + " " + m + " " + l);
			if (record > 0 && correct == 2) {
				Book book = new Book(title, autor, Integer.parseInt(year), s, m, l);
				session.save(book);
			}
			correct = 0;
		}

		session.getTransaction().commit();
		session.close();
	}
	
	private void closeDatabase() {
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		sessionFactory.close();
	}
	
	public boolean databaseIsEmpty(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		List<Book> list=new ArrayList<Book>();
		String sqlQuery="from Book";
		Query query=session.createQuery(sqlQuery);
		query.setMaxResults(1);
		list=query.list();
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		if(list.isEmpty())
			return true;
		else
			return false;
	}







}
