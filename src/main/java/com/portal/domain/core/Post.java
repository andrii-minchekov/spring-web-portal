package com.portal.domain.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	public final static Post DEFAULT_INSTANCE = new Post(100,"First Blog post", 1,
			"Content of first blog post", new Date());
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String title;
	private long bloggerId;
	private String content;
	private Date lastUpdatedDate;
	
	public Post(long id, String title, long blogger, String content, Date lastUpdatedDate) {
		this.id = id;
		this.title = title;
		this.bloggerId = blogger;
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
	public long getBloggerId() {
		return bloggerId;
	}
	public void setBloggerId(long bloggerId) {
		this.bloggerId = bloggerId;
	}

}
