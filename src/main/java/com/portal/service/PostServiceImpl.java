package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.PostDao;
import com.portal.model.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	
	public void getPostById(long id) {
		postDao.get(id);

	}

	public void savePost(Post post) {
		postDao.addPost(post);
	}
	
}
