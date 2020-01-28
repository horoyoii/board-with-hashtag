package com.horoyoii.mvcexam.dao;

import java.util.List;

import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.model.Tag;

public interface articleTagDao {

	// Create
	public void save(int aid, int tid);
	
	// Read
	public List<Tag> getAllTagByAid(int aid);
	public List<Article> getAllAritcleByTid(int tid);
	
}
