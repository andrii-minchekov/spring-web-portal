package com.portal.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.portal.domain.core.Blogger;

public class JdbcBloggerDaoImpl extends SimpleJdbcDaoSupport implements
		BloggerDao {

	private static final String SQL_INSERT_BLOGGER = "insert into blogger (id,firstName,lastName,password,email)"
			+ " values (?,?,?,?,?)";

	public void addBlogger(Blogger blogger) {
		getSimpleJdbcTemplate().update(SQL_INSERT_BLOGGER,
				111, blogger.getFirstName(), blogger.getLastName(),
				blogger.getPassword(), blogger.getEmail());
		//blogger.setId(11);

	}

}
