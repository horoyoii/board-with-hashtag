package com.horoyoii.mvcexam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.horoyoii.mvcexam.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(User User) {
		// TODO Auto-generated method stub
		System.out.println("awef");
		
	}

	@Override
	public User getByUid(int uid) {
		// TODO Auto-generated method stub
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		String query = "select uid, name, age from user where uid = ?";
		User user = jdbcTemplate.queryForObject(query, new Object[]{uid}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}});
		
		return user;
	}

	@Override
	public void update(User User) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByUid(int uid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
