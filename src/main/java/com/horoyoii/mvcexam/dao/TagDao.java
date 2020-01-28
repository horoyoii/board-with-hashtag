package com.horoyoii.mvcexam.dao;

import java.util.List;

import com.horoyoii.mvcexam.model.Tag;

public interface TagDao {

	//Create
	public int save(Tag Tag);
	//Read
	public Tag getByTid(int tid);
	public Tag getByName(String name);
	
	//Update
	public void update(Tag Tag);
	//Delete
	public void deleteByTid(int tid);
	//Get All
	public List<Tag> getAll();	
}
