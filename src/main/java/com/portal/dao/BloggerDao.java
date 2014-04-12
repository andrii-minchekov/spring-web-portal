package com.portal.dao;

import java.util.Collection;
import com.portal.model.Blogger;
import com.portal.model.Post;

public interface BloggerDao {
	
	void addBlogger(Blogger blogger);
	Blogger get(long id);
	Collection<Post> getPostsOfBlogger(Blogger blogger);

	Blogger getBloggerByEmail(String email);

	Blogger getBloggerByLogin(String login);


}
