package com.horoyoii.mvcexam.service;

import java.util.List;

import com.horoyoii.mvcexam.model.Article;

public interface SearchService {

	public List<Article> getAritcleByTag(String name);
	
}
