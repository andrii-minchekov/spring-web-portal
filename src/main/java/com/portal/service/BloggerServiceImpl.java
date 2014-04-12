package com.portal.service;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portal.dao.BloggerDao;
import com.portal.model.Blogger;
import com.portal.model.Post;

@Service(value="bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Inject
	BloggerDao bloggerDao;
	
	@Override
	public void saveBlogger(Blogger blogger) {
		bloggerDao.addBlogger(blogger);
		
	}

	@Override
	public Blogger getBloggerByLogin(String login) {
		return bloggerDao.getBloggerByLogin(login);
	}

	@Override
	public Blogger getBloggerByEmail(String email) {
		return bloggerDao.getBloggerByEmail(email);
	}

	@Override
	public Collection<Post> getPostsOfBlogger(Blogger blogger) {
		return bloggerDao.getPostsOfBlogger(blogger);
		
	}

}
