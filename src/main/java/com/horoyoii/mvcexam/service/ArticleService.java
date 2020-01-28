package com.horoyoii.mvcexam.service;

import com.horoyoii.mvcexam.model.Article;

public interface ArticleService {

	/*
	 * create new article 
	 * using ArticleDao
	 * using TagDao 
	 */
	public void createArticle(Article article);

	/*
	 * return the corresponding article 
	 */
	public Article getArticleById(int aid);
	
	
	public void deleteArticleById(int aid);
}
