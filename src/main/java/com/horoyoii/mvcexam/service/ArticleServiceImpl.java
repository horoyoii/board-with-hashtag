package com.horoyoii.mvcexam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horoyoii.mvcexam.dao.ArticleDaoImpl;
import com.horoyoii.mvcexam.dao.TagDaoImpl;
import com.horoyoii.mvcexam.dao.articleTagDaoImpl;

import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.model.Tag;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired 
    ArticleDaoImpl articleDaoImpl;
    
    @Autowired 
    TagDaoImpl tagDaoImpl;
    
    @Autowired
    articleTagDaoImpl articleTagDaoImpl;
    
	@Override
	public void createArticle(Article article) {
		// 1) save article  
		int aid = articleDaoImpl.save(article);
		System.out.println("pk is "+ aid);
		
		// 2) get related tags list 
		ArrayList<String> tagList = article.getTags();
		ArrayList<Integer> tidList = new ArrayList<>();
		
 		for(int i=0; i <tagList.size(); i++) {
			int tid;
			Tag t = tagDaoImpl.getByName(tagList.get(i));
			
			if(t == null) {
				// generate new record
				tid = tagDaoImpl.save(new Tag(tagList.get(i)));
			}else
				tid = t.getTid();
			
			tidList.add(tid);
		}
		
 		
		// 3) save the article and tags pair into relationship table
 		for(int i=0; i <tidList.size(); i++) {
 	 		articleTagDaoImpl.save(aid, tidList.get(i));
		}
		
	}

	@Override
	public Article getArticleById(int aid) {
		
		// 1) get aritcle 
		Article article = articleDaoImpl.getById(aid);
		
		// 2) get related tags 
		List<Tag> tList = articleTagDaoImpl.getAllTagByAid(aid);
		ArrayList<String> tags = new ArrayList<>();
		
		for(int i=0; i< tList.size(); i++) {
			tags.add(tList.get(i).getName());
		}
		
		article.setTags(tags);
		
		return article;
	}

	@Override
	public void deleteArticleById(int aid) {
		articleDaoImpl.deleteById(aid);

	}

}
