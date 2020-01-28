package com.horoyoii.mvcexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horoyoii.mvcexam.dao.TagDaoImpl;
import com.horoyoii.mvcexam.dao.articleTagDaoImpl;
import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.model.Tag;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired 
    TagDaoImpl tagDaoImpl;
    
    @Autowired
    articleTagDaoImpl articleTagDaoImpl;
	
	@Override
	public List<Article> getAritcleByTag(String name) {
		Tag t = tagDaoImpl.getByName(name);
		
		return articleTagDaoImpl.getAllAritcleByTid(t.getTid());
	}

}
