package com.portal.service;

import com.portal.model.Post;

public interface PostService {
	void getPostById(long id);
	
	void savePost(Post post);
}
