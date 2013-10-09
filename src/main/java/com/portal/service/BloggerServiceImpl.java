package com.portal.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portal.dao.BloggerDao;
import com.portal.domain.core.Blogger;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blogger getBloggerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPostsOfBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

}
