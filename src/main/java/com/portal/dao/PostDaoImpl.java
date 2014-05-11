package com.portal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.portal.model.Post;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PostDaoImpl implements PostDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Post get(long id) {
        return em.find(Post.class, id);
	}

    @Override
    public List<Post> getAllPosts() {
        Query query = em.createQuery("from Post");
        return query.getResultList();
    }

    @Override
    public boolean deletePost(long id) {
        Post post = em.find(Post.class, id);
        em.remove(post);
        return true;
    }

    @Override
	public void addPost(Post post) {
		em.persist(post);

	}

}
