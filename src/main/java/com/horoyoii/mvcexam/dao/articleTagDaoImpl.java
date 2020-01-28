package com.horoyoii.mvcexam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.model.Tag;


@Repository
public class articleTagDaoImpl implements articleTagDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(int aid, int tid) {
		String sql = "INSERT INTO article_tag (aid, tid)"
                + " VALUES (?, ?)";
		
		jdbcTemplate.update(sql, aid, tid);
	}

	/*
	  select tag.tid, tag.name  
	  from article_tag 
	  join tag 
	  on article_tag.tid = tag.tid 
	  join article 
	  on article.aid = article_tag.aid 
	  where article.title ='harry potter';

	  select tag.tid, tag.name  
	  from article_tag 
	  join tag 
	  on article_tag.tid = tag.tid 
	  where article_tag.aid = 2;
	 */
	@Override
	public List<Tag> getAllTagByAid(int aid) {
	    String sql =
	    "select tag.tid, tag.name " + 
	    "from article_tag " + 
	    "join tag " + 
	    "on article_tag.tid = tag.tid " + 
	    "where article_tag.aid = ?";
	    
	    List<Tag> listTag = jdbcTemplate.query(sql, new Object[] {aid}, new RowMapper<Tag>() {
	 
	        @Override
	        public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Tag aTag = new Tag();
	 
	            aTag.setTid(rs.getInt("tid"));
	            aTag.setName(rs.getString("name"));
	         
	            return aTag;
	        }
	 
	    });
	 
	    return listTag;
	}

	@Override
	public List<Article> getAllAritcleByTid(int tid) {
	    String sql =
	    "select * " + 
	    "from article_tag " + 
	    "join article " + 
	    "on article_tag.aid = article.aid " + 
	    "where article_tag.tid = ?";
	    
	    List<Article> listAritcle = jdbcTemplate.query(sql, new Object[] {tid}, new RowMapper<Article>() {
	 
	        @Override
	        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Article aArticle = new Article();

					aArticle.setAid(rs.getInt("aid"));
					aArticle.setTitle(rs.getString("title"));
					aArticle.setContent(rs.getString("content"));
					aArticle.setWriter(rs.getString("writer"));
					aArticle.setRegDate(rs.getDate("regDate"));
	         
	            return aArticle;
	        }
	 
	    });
	 
	    return listAritcle;
		}

}
