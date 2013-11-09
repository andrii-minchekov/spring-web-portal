package com.portal.dao;

import java.util.Collection;
import com.portal.domain.core.Blogger;
import com.portal.domain.core.Post;

//@Lazy
//@Repository
public class JdbcBloggerDaoImpl implements BloggerDao{

	@Override
	public void addBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Blogger get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Post> getPostsOfBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blogger getBloggerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blogger getBloggerByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	/*private static final String SQL_UPDATE_BLOGGER = "update blogger set firstName = ? ,lastName = ?, login = ?,password = ?,email=?,lastupdateddate=?";

	
	 * public void addBlogger(Blogger blogger) {
	 * getSimpleJdbcTemplate().update(SQL_INSERT_BLOGGER, 111,
	 * blogger.getFirstName(), blogger.getLastName(), blogger.getLogin(),
	 * blogger.getPassword(), blogger.getEmail()); //blogger.setId(11);
	 * 
	 * }
	 

	private DataSource dataSource;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Autowired
	public void setSimpleJdbcTemplate(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	

	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	private SimpleJdbcInsert insertBlogger;
	
	@Autowired
	public void setInsertBlogger() {
		insertBlogger = new SimpleJdbcInsert(dataSource).withTableName("blogger").usingGeneratedKeyColumns("id");
		insertBlogger = new SimpleJdbcInsert(dataSource).withTableName("blogger");
		insertBlogger.setGeneratedKeyName("id");
	}
			

	@Transactional
	public void addBlogger(Blogger blogger) {
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		// parameters.put("id", blogger.getId());
		parameters.put("firstName", blogger.getFirstName());
		parameters.put("lastName", blogger.getLastName());
		parameters.put("login", blogger.getLogin());
		parameters.put("password", blogger.getPassword());
		parameters.put("email", blogger.getEmail());
		parameters.put("lastUpdatedDate", new Date());
		Number key = insertBlogger.executeAndReturnKey(parameters);
		blogger.setId(key.longValue());
	}

	KeyHolder keyHolder = new GeneratedKeyHolder();

	public void updateBlogger(final Blogger blogger) {
		getSimpleJdbcTemplate().getJdbcOperations().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(
							Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(
								SQL_UPDATE_BLOGGER,
								Statement.RETURN_GENERATED_KEYS);
						// ps.setString(1, keyHolder.getKey().toString());
						ps.setString(1, blogger.getFirstName());
						ps.setString(2, blogger.getLastName());
						ps.setString(3, blogger.getLogin());
						ps.setString(4, blogger.getPassword());
						ps.setString(5, blogger.getEmail());
						ps.setDate(5, (java.sql.Date) new Date());
						return ps;
					}
				}, keyHolder);
		// blogger.setId(keyHolder.getKey().longValue());
	}

	@Override
	public List<Post> getPostsOfBlogger(final Blogger blogger) {
		return getSimpleJdbcTemplate().query("select * from post where bloggerid = ?", new PostRowMapper(),blogger.getId());
		
	}
	
	@Override
	public Blogger getBloggerByEmail(String email) {
		return getSimpleJdbcTemplate().queryForObject("select * from blogger where email=:email", new BloggerRowMapper(), 
				new  MapSqlParameterSource().addValue("email", email));
	}
	
	@Override
	public Blogger getBloggerByLogin(String login) {
		return getSimpleJdbcTemplate().queryForObject("select * from blogger where login=:login", new BloggerRowMapper(), 
				new  MapSqlParameterSource().addValue("login", login));
	}
	
	private static class PostRowMapper implements RowMapper<Post> {

		@Override
		public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
			Post post = new Post();
			post.setId(rs.getLong("id"));
			post.setContent(rs.getString("content"));
			//post.setBloggerId(rs.getLong("bloggerId"));
			post.setLastUpdatedDate(rs.getDate("lastUpdatedDate"));
			post.setTitle(rs.getString("title"));
			return post;
		}
		
	}
	
	private static class BloggerRowMapper implements RowMapper<Blogger> {

		public Blogger mapRow(ResultSet rs, int rowNum) throws SQLException {
			Blogger blogger = new Blogger();
			blogger.setId(rs.getLong("id"));
			blogger.setFirstName(rs.getString("firstName"));
			blogger.setLastName(rs.getString("lastName"));
			blogger.setEmail(rs.getString("email"));
			blogger.setLogin(rs.getString("login"));
			return blogger;
		}
		
	}

	@Override
	public Blogger get(long id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
