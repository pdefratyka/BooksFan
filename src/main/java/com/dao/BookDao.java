package com.dao;

import java.util.List;

import com.entities.Book;

public interface BookDao {
	/*POST, PUT, DELETE*/
	public Book addBook(Book book);
	public Book editBook(Book book, Long bookId);
	public void deleteBook(Long bookId);
	public void setWantToRead(Long bookId, Long userId, int wantRead);
	public void setComment(Long bookId, Long userId, String comment);
	public void rateBook(Long bookId, Long userId, int rate);
	/*GET*/
	public Book getBookById(Long id);
	public List<Book> getBookByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	
	public int getRate(long bookId);
	public List<Integer> getPersonalRate(Long bookId,Long userId);

	public String getComment(long bookId, long userId);
	
}
