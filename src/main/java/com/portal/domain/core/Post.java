package com.portal.domain.core;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Post {
	public final static Post DEFAULT_INSTANCE = new Post(100,
			"First Blog post", new Blogger(), "Content of first blog post",
			new Date());

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Size(min = 1)
	private String title;

	@ManyToOne
	@JoinColumn(name = "BLOGGER_ID")
	private Blogger blogger;

	@Size(min = 1)
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String content;

	private Date lastUpdatedDate;

	public Post(long id, String title, Blogger blogger, String content,
			Date lastUpdatedDate) {
		this.id = id;
		this.title = title;
		// this.blogger = blogger;
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

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

}
