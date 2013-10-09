package com.portal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.portal.domain.core.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Post get(long id) {
		return em.find(Post.class, id);
	}

	public void addPost(Post post) {
		em.persist(post);

	}

}
