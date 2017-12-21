package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BookDao;
import com.entities.Book;
import com.services.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public Book getBookById(Long id) {
		return bookDao.getBookById(id);
	}
	@Transactional
	public List<Book> getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}
	@Transactional
	public List<Book> getBooksByAuthor(String author) {
		return bookDao.getBooksByAuthor(author);
	}
	@Transactional
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}
	@Transactional
	public Book editBook(Book book, Long bookId) {
		return bookDao.editBook(book, bookId);
	}
	@Transactional
	public void deleteBook(Long bookId) {
		bookDao.deleteBook(bookId);		
	}
	@Transactional
	public void rateBook(Long bookId, Long userId, int rate) {
		bookDao.rateBook(bookId, userId, rate);
		
	}
	@Transactional
	public List<Integer> gerPersonalRate(Long bookId, Long userId) {
		return bookDao.getPersonalRate(bookId, userId);
	}
	@Transactional
	public void setWantToRead(long bookId, long userId, int wantRead) {
		bookDao.setWantToRead(bookId, userId, wantRead);
		
	}
	@Transactional
	public void setComment(long bookId, long userId, String comment) {
		bookDao.setComment(bookId, userId, comment);
		
	}
	@Transactional
	public String getComment(long bookId, long userId) {
		return bookDao.getComment(bookId, userId);
		
	}
	@Transactional
	public int getRate(long bookId) {
		return bookDao.getRate(bookId);
	}
}
