package com.portal.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.portal.domain.core.Blogger;
import com.portal.domain.core.Post;

@Repository(value = "bloggerDao")
public class BloggerDaoImpl implements BloggerDao {

	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager em;

	@Override
	//@Transactional
	public Blogger get(long id) {
		return em.find(Blogger.class, id);
	}

	@Override
	//@Transactional
	public void addBlogger(Blogger blogger) {
		em.persist(blogger);
		//em.flush();
	}

	@Override
	//@Transactional
	public Collection<Post> getPostsOfBlogger(Blogger blogger) {
		Query query = em.createQuery("from Post as p where p.blogger = ?1");
		query.setParameter(1, blogger);
		return query.getResultList();
		//return blogger.getPostList();
	}

	@Override
	//@Transactional
	public Blogger getBloggerByEmail(String email) {
		Query query = em.createQuery("from Blogger where email=?1");
		query.setParameter(1, email);
		return (Blogger) query.getSingleResult();
	}

	@Override
	//@Transactional
	public Blogger getBloggerByLogin(String login) {
		Query query = em.createQuery("from Blogger where login=?1");
		query.setParameter(1, login);
		return (Blogger) query.getSingleResult();
	}
}
