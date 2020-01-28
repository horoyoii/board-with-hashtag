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

import com.horoyoii.mvcexam.model.Tag;


@Repository
public class TagDaoImpl implements TagDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public int save(Tag tag) {
		String sql = "INSERT INTO tag(name)"
                + " VALUES (?)";
		
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, tag.getName());
				return ps;
			}
		}, holder);

		return holder.getKey().intValue();			
	}

	@Override
	public Tag getByTid(int tid) {
		String query = "select * from tag where tid = ?";
		Tag tag = jdbcTemplate.queryForObject(query, new Object[]{tid}, new RowMapper<Tag>(){

			@Override
			public Tag mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Tag tag = new Tag();
				tag.setTid(rs.getInt("tid"));
				tag.setName(rs.getString("name"));
				
				return tag;
			}});
		
		return tag;	
	}
	
	@Override
	public Tag getByName(String name) {
		String query = "select * from tag where name = ?";
		
		List<Tag> tagList = jdbcTemplate.query(query, new Object[]{name}, new RowMapper<Tag>(){

			@Override
			public Tag mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Tag tag = new Tag();
				tag.setTid(rs.getInt("tid"));
				tag.setName(rs.getString("name"));
				
				return tag;
			}});
		
		if(tagList.isEmpty())
			return null;
		else
			return tagList.get(0);
	}

	@Override
	public void update(Tag Tag) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Tag> getAll() {
	    String sql = "SELECT * FROM Tag";
	    List<Tag> listTag = jdbcTemplate.query(sql, new RowMapper<Tag>() {
	 
	        @Override
	        public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Tag aTag = new Tag();
	 
	            aTag.setTid(rs.getInt("Tid"));
	            aTag.setName(rs.getString("name""));
	            return aTag;
	        }
	 
	    });
	 
	    return listTag;
	}


	@Override
	public void deleteByTid(int tid) {
		// TODO Auto-generated method stub
		
	}

}
