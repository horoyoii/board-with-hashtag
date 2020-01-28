package com.horoyoii.mvcexam.dao;

import java.util.List;

import com.horoyoii.mvcexam.model.Comment;

public interface CommentDao {
	//Create
	public void save(Comment Comment);
	
	//Read
	public Comment getByCid(int cid);
	
	//Update
	public void update(Comment Comment);
	
	//Delete
	public void deleteByCid(int cid);
	
	//Get All by aid
	public List<Comment> getAllByAid(int aid);	
}
