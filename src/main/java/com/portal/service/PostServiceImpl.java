package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.dao.PostDao;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Transactional
	public void getPostById(long id) {
		postDao.get(id);

	}

}
