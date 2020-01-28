package com.horoyoii.mvcexam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.horoyoii.mvcexam.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void save(Comment comment) {
		String sql = "INSERT INTO comment (content, aid)"
                + " VALUES (?, ?)";
		
		jdbcTemplate.update(sql, comment.getContent(), comment.getAid());
	}

	@Override
	public Comment getByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Comment Comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByCid(int cid) {
		// TODO Auto-generated method stub
	    String sql = "DELETE FROM comment WHERE cid=?";
	    jdbcTemplate.update(sql, cid);
	}

	@Override
	public List<Comment> getAllByAid(int aid) {
	    String sql = "SELECT * FROM comment where aid = ?";
	    List<Comment> listComment = jdbcTemplate.query(sql, new Object[] {aid}, new RowMapper<Comment>() {
	 
	        @Override
	        public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Comment aComment = new Comment();
	 
	            aComment.setCid(rs.getInt("cid"));
	            aComment.setContent(rs.getString("content"));
	            aComment.setRegdate(rs.getDate("regdate"));
	            aComment.setAid(rs.getInt("aid"));
	         
	            return aComment;
	        }
	 
	    });
	 
	    return listComment;
	}

}
