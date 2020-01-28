package com.horoyoii.mvcexam.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.horoyoii.mvcexam.dao.ArticleDaoImpl;
import com.horoyoii.mvcexam.model.Article;
import com.horoyoii.mvcexam.service.ArticleServiceImpl;

/**
 * Handles requests for the application home page.
*
 *
 * /api/v1/article/1/comment/2
 * 
 */


@Controller
@RequestMapping("/article") 
public class ArticleController {
	
    @Autowired 
    ArticleServiceImpl articleServiceImpl;
    
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView createGet() {

		ModelAndView mv = new ModelAndView("article_create", "command", new Article());
		
		return mv;
	}		
	
	/*
	 * TODO: form tag 넘기는 방식 너무 복잡
	 * 
	 *  return "redirect:/board" - 같은 도메인 내에서의 절대 URL
	 */
	@PostMapping()
	public String createPost(@ModelAttribute("SpringWeb")Article article) {

		System.out.println(article.getTags());
		articleServiceImpl.createArticle(article);
		
		return "redirect:/board";
	}	

	/*
	 * TODO : query string 이 아닌 path variable 쓰는 방법 detail 
	 */
	@GetMapping("/{aid}")
	public String read(@PathVariable("aid") int aid,
			Model model) {
		model.addAttribute("article", articleServiceImpl.getArticleById(aid));
		
		return "index";
	}
	

	/*
	 * client로부터 ajax 요청을 받아 
	 * delete 수행 후 view 없이 상태코드 반환  
	 */
	@DeleteMapping("/{aid}")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable("aid") int aid) {
		articleServiceImpl.deleteArticleById(aid);
		
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}	

	
}
