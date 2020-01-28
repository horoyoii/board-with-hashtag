package com.horoyoii.mvcexam.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.horoyoii.mvcexam.dao.ArticleDaoImpl;
import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.service.SearchServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board") 
public class BoardController {
    @Autowired 
    ArticleDaoImpl articleDaoImpl;
    
    @Autowired
    SearchServiceImpl searchServiceImpl;
    
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView board(@RequestParam(required=false) String search, 
			ModelAndView model) {
		List<Article> listArticle;
		if(search == null) {
			listArticle= articleDaoImpl.getAll();
		}else {
			listArticle = searchServiceImpl.getAritcleByTag(search);
		}
		
	    model.addObject("listArticle", listArticle);
	    
	    model.setViewName("boardList");
		return model;
	}
	

	
}
