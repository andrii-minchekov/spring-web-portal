package com.portal.domain.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	public final static Post DEFAULT_INSTANCE = new Post(100,"First Blog post","aminchekov",
			"Content of first blog post", new Date());
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String title;
	private String author;
	private String content;
	private Date lastUpdatedDate;
	
	public Post(long id, String title,String author, String content, Date lastUpdatedDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public Post() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
