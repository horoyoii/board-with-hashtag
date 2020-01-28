package com.horoyoii.mvcexam.dao;

import java.util.List;

import com.horoyoii.mvcexam.model.Article;

public interface ArticleDao {

	//Create - return a generated pk
	public int save(Article Article);
	//Read
	public Article getById(int aid);
	//Update
	public void update(Article Article);
	//Delete
	public void deleteById(int aid);
	//Get All
	public List<Article> getAll();	
}
