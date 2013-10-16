package com.portal.service;

import com.portal.domain.core.Post;

public interface PostService {
	void getPostById(long id);
	
	void savePost(Post post);
}
