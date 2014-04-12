package com.portal.service;

import java.util.Collection;

import com.portal.model.Blogger;
import com.portal.model.Post;

public interface BloggerService {

	public void saveBlogger(Blogger blogger);

	public Blogger getBloggerByLogin(String login);

	public Blogger getBloggerByEmail(String email);

	public Collection<Post> getPostsOfBlogger(Blogger blogger);

}