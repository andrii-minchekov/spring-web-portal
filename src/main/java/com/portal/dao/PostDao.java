package com.portal.dao;

import com.portal.domain.core.Post;

public interface PostDao {
	
	void addPost(Post post);

	Post get(long id);

}
