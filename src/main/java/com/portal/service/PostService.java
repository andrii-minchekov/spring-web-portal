package com.portal.service;

import com.portal.model.Post;

import java.util.List;

public interface PostService {

    void getPostById(long id);
	
	void savePost(Post post);

    List<Post> getAllPosts();

    boolean deletePost(long id);
}
