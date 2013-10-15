package com.portal.service;

import java.util.List;

import com.portal.domain.core.Blogger;
import com.portal.domain.core.Post;

public interface BloggerService {

	public void saveBlogger(Blogger blogger);

	public Blogger getBloggerByLogin(String login);

	public Blogger getBloggerByEmail(String email);

	public List<Post> getPostsOfBlogger(Blogger blogger);

}