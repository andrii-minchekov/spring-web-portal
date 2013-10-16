package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.dao.PostDao;
import com.portal.domain.core.Post;

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
