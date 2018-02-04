package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Book;
import com.services.BookService;
import com.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	/*YOLO*/
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String book() {
		return "book";
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Cache-Control","no-cache, no-store, must-revalidate");
		return new ResponseEntity<Book>(bookService.getBookById(id),httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Book>> getBookByTitle(@RequestParam(value = "query", required = false) String query,
									@RequestParam(value = "author", required = false) String author) {
		List<Book>list=bookService.getBooksByAuthor(query);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Cache-Control","no-cache, no-store, must-revalidate");
		if(list.size()>0)
			return new ResponseEntity<List<Book>>(list,httpHeaders, HttpStatus.OK);

		else{
			list=bookService.getBookByTitle(query);
			return new ResponseEntity<List<Book>>(list,httpHeaders, HttpStatus.OK);
		}
		

	}
	
	@RequestMapping(value="addbook", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Book addBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public Book editBook(@RequestBody Book book, @PathVariable("id") long bookId){
		return bookService.editBook(book, bookId);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteBook(@PathVariable("id") long bookId){
		bookService.deleteBook(bookId);
	}
	
	@RequestMapping(value="/{id}/rate/{value}", method=RequestMethod.POST)
	@ResponseBody
	public String rateBook(@PathVariable("id") long bookId, @PathVariable("value") int rate,
							@RequestParam("login") String login){
		Long userId=userService.getUserId(login);
		bookService.rateBook(bookId, userId, rate);
		return Integer.toString(rate);
	}
	
	@RequestMapping(value="/{bookId}/wantread/{value}", method=RequestMethod.POST)
	@ResponseBody
	public void wantToRead(@PathVariable("bookId")long bookId, @PathVariable("value")int wantRead, 
							@RequestParam("login") String login){
		bookService.setWantToRead(bookId, userService.getUserId(login), wantRead);
	}
	
	@RequestMapping(value="/{bookId}/rate/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public List<Integer> getPrivateRate(@PathVariable("bookId") long bookId, @PathVariable("userId") long userId){
		return bookService.gerPersonalRate(bookId, userId);
	}
	
	@RequestMapping(value="/{bookId}/rate",method=RequestMethod.GET)
	@ResponseBody
	public int getRate(@PathVariable("bookId")long bookId){
		return bookService.getRate(bookId);
	}
	
	@RequestMapping(value="/{bookId}/{login}/comment", method=RequestMethod.POST)
	@ResponseBody
	public void setComment(@PathVariable("bookId")long bookId, @PathVariable("login") String login, 
							@RequestParam("comment")String comment){
		Long userId=userService.getUserId(login);
		bookService.setComment(bookId, userId, comment);
	}
	@RequestMapping(value="/{bookId}/{userId}/comment", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getComment(@PathVariable("bookId")long bookId, @PathVariable("userId") long userId){
		List<String> list=new ArrayList<String>();
		list.add(bookService.getComment(bookId, userId));
		return list;
	}
}
