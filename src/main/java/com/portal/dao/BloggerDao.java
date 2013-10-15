package com.portal.dao;

import java.util.List;

import com.portal.domain.core.Blogger;
import com.portal.domain.core.Post;

public interface BloggerDao {
	void addBlogger(Blogger blogger);

	List<Post> getPostsOfBlogger(Blogger blogger);

	Blogger getBloggerByEmail(String email);

	Blogger getBloggerByLogin(String login);


}
