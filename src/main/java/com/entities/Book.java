package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", length = 11)
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name="year")
	private int year;
	@Column(name="imageS")
	private String imageS;
	@Column(name="imageM")
	private String imageM;
	@Column(name="imageL")
	private String imageL;
	@Column(name="rate")
	private int rate;
	@Column(name="manyOfRead")
	private int manyOfRead;
	public Book(){
		
	}
	
	public Book(String title, String author, int year, String imageS, String imageM, String imageL){
		this.title=title;
		this.author=author;
		this.year=year;
		this.imageS=imageS;
		this.imageM=imageM;
		this.imageL=imageL;
	}
	public Book(String title, String author, int year, String imageS, long id){
		this.title=title;
		this.author=author;
		this.year=year;
		this.imageS=imageS;
		this.imageM=imageS;
		this.imageL=imageS;
		this.id=id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return this.author;
	}
	
	public void setYear(int year){
		this.year=year;
	}
	public int getYear(){
		return this.year;
	}
	public void setImageS(String imageS){
		this.imageS=imageS;
	}
	public String getImageS(){
		return this.imageS;
	}
	public void setImageM(String imageM){
		this.imageM=imageM;
	}
	public String getImageM(){
		return this.imageM;
	}
	public void setImageL(String imageL){
		this.imageL=imageL;
	}
	public String getImageL(){
		return this.imageL;
	}
	public void setRate(int rate){
		this.rate=rate;
	}
	public int getRate(){
		return this.rate;
	}
	public void setManyOfRead(int manyOfRead){
		this.manyOfRead=manyOfRead;
	}
	public int getManyOfRead(){
		return this.manyOfRead;
	}

}
