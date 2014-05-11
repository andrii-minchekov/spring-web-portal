package com.portal.dao;

import com.portal.model.Post;

import java.util.List;

public interface PostDao {
	
	void addPost(Post post);

	Post get(long id);

    List<Post> getAllPosts();

    boolean deletePost(long id);

}
