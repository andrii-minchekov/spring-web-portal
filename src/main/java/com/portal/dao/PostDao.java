package com.portal.dao;

import com.portal.model.Post;

public interface PostDao {
	
	void addPost(Post post);

	Post get(long id);

}
