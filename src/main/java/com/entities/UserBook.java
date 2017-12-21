package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users_books")
public class UserBook {
	@Id
	@Column(name="rowId")
	private long rowId;
	@Column(name="users_id")
	private long userId;
	@Column(name="books_id")
	private long bookId;
	@Column(name="rate")
	private int rate;
	@Column(name="wantToRead")
	private int wantToRead;
	@Column(name="comment")
	private String comment;
	public UserBook(){
		
	}
	public UserBook(long userId, long bookId, int rate){
		this.userId=userId;
		this.bookId=bookId;
		this.rate=rate;
	}
	public void setUserId(long userId){
		this.userId=userId;
	}
	public long getUserId(){
		return this.userId;
	}
	public void setBookId(long bookId){
		this.bookId=bookId;
	}
	public long getBookId(){
		return this.bookId;
	}
	public void setRate(int rate){
		this.rate=rate;
	}
	public int getRate(){
		return rate;
	}
	public void setRowId(long rowId){
		this.rowId=rowId;
	}
	public long getRowId(){
		return this.rowId;
	}
	public void setWantToRead(int wantToRead){
		this.wantToRead=wantToRead;
	}
	public int getWantToRead(){
		return this.wantToRead;
	}
	public void setComment(String comment){
		this.comment=comment;
	}
	public String getComment(){
		return this.comment;
	}
}
