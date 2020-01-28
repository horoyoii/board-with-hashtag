package com.horoyoii.mvcexam.dao;

import java.util.List;

import com.horoyoii.mvcexam.model.User;

public interface UserDao {

	//Create
	public void save(User User);
	//Read
	public User getByUid(int uid);
	//Update
	public void update(User User);
	//Delete
	public void deleteByUid(int uid);
	//Get All
	public List<User> getAll();	
}
