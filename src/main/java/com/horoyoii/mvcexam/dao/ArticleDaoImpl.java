package com.horoyoii.mvcexam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.horoyoii.mvcexam.model.Article;

/*
 * TODO: to separate the codes with SQL statements
 */

@Repository
public class ArticleDaoImpl implements ArticleDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* TODO: transaction 처리 
	 * https://gist.github.com/mdellabitta/1444003
	 * https://www.mysqltutorial.org/mysql-jdbc-transaction/
	 */
	@Override
	public int save(Article article) {
		String sql = "INSERT INTO article (title, content, writer)"
                + " VALUES (?, ?, ?)";
		/*
		jdbcTemplate.update(sql, article.getTitle(), article.getContent(),
				article.getWriter());
		*/
		// 1) INSERT new article and get a generated primary key
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, article.getTitle());
				ps.setString(2, article.getContent());
				ps.setString(3, article.getWriter());
				return ps;
			}
		}, holder);

		int newAid = holder.getKey().intValue();	
		
		return newAid;
	}

	@Override
	public Article getById(int Aid) {
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		String query = "select * from article where aid = ?";
		Article article = jdbcTemplate.queryForObject(query, new Object[]{Aid}, new RowMapper<Article>(){

			@Override
			public Article mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setWriter(rs.getString("writer"));
				article.setRegDate(rs.getDate("regDate"));
				
				return article;
			}});
		
		return article;
	}

	@Override
	public void update(Article Article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int Aid) {
		// TODO Auto-generated method stub
	    String sql = "DELETE FROM article WHERE aid=?";
	    jdbcTemplate.update(sql, Aid);

	}

	@Override
	public List<Article> getAll() {
	    String sql = "SELECT * FROM article";
	    List<Article> listArticle = jdbcTemplate.query(sql, new RowMapper<Article>() {
	 
	        @Override
	        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Article aArticle = new Article();
	 
	            aArticle.setAid(rs.getInt("aid"));
	            aArticle.setTitle(rs.getString("title"));
	            aArticle.setContent(rs.getString("content"));
	            aArticle.setWriter(rs.getString("writer"));
	            aArticle.setRegDate(rs.getDate("regdate"));
	 
	            return aArticle;
	        }
	 
	    });
	 
	    return listArticle;
	}

}
