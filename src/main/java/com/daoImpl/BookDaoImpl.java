package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BookDao;
import com.entities.Book;
import com.entities.User;
import com.entities.UserBook;

@Repository("bookDao")
public class BookDaoImpl implements BookDao{

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public Book getBookById(Long id) {
		Session session=sessionFactory.getCurrentSession();

		String sqlQuery="from Book b where b.id=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, id);
		
		Book book=(Book) query.list().get(0);
		return book;
	}

	public List<Book> getBookByTitle(String title) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from Book b where b.title like ?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0,"%"+title+"%");
		query.setMaxResults(50);
		List<Book> booksList=query.list();


		return booksList;
	}

	public List<Book> getBooksByAuthor(String author) {
		if(author==""){
			Session session=sessionFactory.getCurrentSession();
			String sqlQuery="from Book";
			Query query=session.createQuery(sqlQuery);
			query.setMaxResults(50);
			List<Book> booksList=query.list();
		}
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from Book b where b.author like ?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, "%"+author+"%");
		query.setMaxResults(50);
		List<Book> booksList=query.list();

		return booksList;
	}

	public Book addBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		session.save(book);
		return book;
	}

	public Book editBook(Book book, Long bookId) {

		Session session=sessionFactory.getCurrentSession();
		Book newBook=book;
		newBook.setId(bookId);
		session.update(newBook);
		

		return book;
	}

	public void deleteBook(Long bookId) {

		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from Book b where b.id=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		Book book=(Book) query.list().get(0);
		session.delete(book);

		
	}

	public void rateBook(Long bookId, Long userId, int rate) {
		int previousRate=0;
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook ub where ub.bookId=? and ub.userId=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		if(query.list().size()>0){
			UserBook userBook=(UserBook) query.list().get(0);
			previousRate=userBook.getRate();
			Long rowId=userBook.getRowId();
			sqlQuery="update UserBook ub set ub.rate=?, ub.wantToRead='0' where ub.rowId=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, rate);
			query.setParameter(1, rowId);
			query.executeUpdate();
			
			int[] result=countRate(rate, bookId, previousRate, false);//result[0]=Rate, result[1]=views
			sqlQuery="update Book b set b.rate=?, b.manyOfRead=? where b.id=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, result[0]);
			query.setParameter(1, result[1]);
			query.setParameter(2, bookId);
			query.executeUpdate();

			
		}
		else{

			
			session.save(new UserBook(userId, bookId, rate));
			
			int[] result=countRate(rate, bookId, previousRate, true);//result[0]=Rate, result[1]=views
			sqlQuery="update Book b set b.rate=?, b.manyOfRead=? where b.id=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, result[0]);
			query.setParameter(1, result[1]);
			query.setParameter(2, bookId);
			query.executeUpdate();

		}

	}

	public List<Integer> getPersonalRate(Long bookId, Long userId) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook ub where ub.bookId=? and ub.userId=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		UserBook userBook=(UserBook) query.list().get(0);
		List<Integer> personalData=new ArrayList<Integer>();
		personalData.add(userBook.getRate());
		personalData.add(userBook.getWantToRead());
		return personalData;
	}

	public void setWantToRead(Long bookId, Long userId, int wantRead) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook ub where ub.bookId=? and ub.userId=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		if(query.list().size()>0){
			UserBook userBook=(UserBook) query.list().get(0);
			Long rowId=userBook.getRowId();
			sqlQuery="update UserBook ub set ub.wantToRead=?, ub.rate='0' where ub.rowId=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, wantRead);
			query.setParameter(1, rowId);
			query.executeUpdate();
			
		}
		else{
			UserBook userBook=new UserBook();
			userBook.setBookId(bookId);
			userBook.setUserId(userId);
			userBook.setWantToRead(wantRead);
			session.save(userBook);
		}
		

		
	}

	public void setComment(Long bookId, Long userId, String comment) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook ub where ub.bookId=? and ub.userId=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		if(query.list().size()>0){
			UserBook userBook=(UserBook) query.list().get(0);
			Long rowId=userBook.getRowId();
			sqlQuery="update UserBook ub set ub.comment=? where ub.rowId=?";
			query=session.createQuery(sqlQuery);
			query.setParameter(0, comment);
			query.setParameter(1, rowId);
			query.executeUpdate();
			
		}
	}

	public String getComment(long bookId, long userId) {
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from UserBook ub where ub.bookId=? and ub.userId=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		query.setParameter(1, userId);
		UserBook userBook=(UserBook) query.list().get(0);
		return userBook.getComment();
		
	}

	public int getRate(long bookId) {
		return 0;
	}
	
	private int[] countRate(int rate, long bookId, int previousRate, boolean firstTime){
		Session session=sessionFactory.getCurrentSession();
		String sqlQuery="from Book b where b.id=?";
		Query query=session.createQuery(sqlQuery);
		query.setParameter(0, bookId);
		Book book=(Book)query.list().get(0);
		int generalRate=book.getRate();
		int manyOfRead=book.getManyOfRead();
		int finalRate=0;
		int[] result=new int[2];
		
		if(firstTime){
			finalRate=(manyOfRead*generalRate+rate)/(manyOfRead+1);
			result[1]=manyOfRead+1;
		}		
		else{
			int k=0;
			if(manyOfRead==0){
				manyOfRead=1;
				k=1;
				result[1]=manyOfRead;
			}
				
			finalRate=(manyOfRead*generalRate-previousRate+rate)/(manyOfRead);
			result[1]=manyOfRead;
		}
		
		

		result[0]=finalRate;		
		return result;
	}


}
