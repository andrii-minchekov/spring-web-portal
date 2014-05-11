package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.PostDao;
import com.portal.model.Post;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	
	public void getPostById(long id) {
		postDao.get(id);

	}

	public void savePost(Post post) {
		postDao.addPost(post);
	}

    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @Override
    public boolean deletePost(long id) {
        return postDao.deletePost(id);
    }

}
