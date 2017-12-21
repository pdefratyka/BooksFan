package com.services;

import java.util.List;

import com.entities.Book;

public interface BookService {
	/*POST, PUT, DELETE*/
	public Book addBook(Book book);
	public Book editBook(Book book, Long bookId);
	public void deleteBook(Long bookId);
	public void rateBook(Long bookId, Long userId, int rate);
	public void setWantToRead(long bookId, long userId, int wantRead);
	public void setComment(long bookId, long userId, String comment);
	/*GET*/
	public Book getBookById(Long id);
	public List<Book> getBookByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Integer> gerPersonalRate(Long bookId, Long userId);
	public String getComment(long bookId, long userId);
	public int getRate(long bookId);
}
