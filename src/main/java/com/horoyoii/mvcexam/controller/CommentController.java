package com.horoyoii.mvcexam.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import com.horoyoii.mvcexam.dao.CommentDaoImpl;
import com.horoyoii.mvcexam.model.Comment;


/**
 * Handles requests for the application home page.
 * 
 * [GET] /api/v1/article/:aid/comment
 * 
 * 
 * [GET] /api/v1/article/:aid/comment/:cid
 *  -> [200 Ok] with body
 *   
 * [POST] /api/v1/article/:aid/comment
 * -> success : [201 Created] "Location Header" pointing to the location of the new source
 * -> fail : 	  [200 OK] doesn't result in a creation
 *  
 * [PUT] /api/v1/article/:aid/comment/:cid
 * -> [200 OK]
 * 
 * [DELETE] /api/v1/article/:aid/comment/:cid
 *  -> [204 No Content] or [200 Ok] no body 
 */
@RestController
@RequestMapping("/api/v1/article/{aid}/comment") 
public class CommentController {
    @Autowired 
    CommentDaoImpl commentDaoImpl;
    
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	/*
	 * 
	 * 	Response Header 
	 * 		- Content-Type: application/json;charset=UTF-8
	 */
	@GetMapping
	public Map<String, Object> commentAll(@PathVariable(value = "aid") int aid) {
		Map<String, Object> map = new HashMap<>();
		List<Comment> comments = commentDaoImpl.getAllByAid(aid);
		map.put("aid", aid);
		map.put("result", comments);
		
		return map;
	}
	
	/*
	 *  TODO: ajax : content-type vs data-type(accept)
	 * 
	 */
	@PostMapping(
			consumes= "application/json")
	public ResponseEntity<String> commentCreate(@RequestBody Comment comment,
			@PathVariable(value = "aid") int aid) {
		
		commentDaoImpl.save(comment);
		
		// TODO : add the created resource's location
		return new ResponseEntity<>("ok",HttpStatus.CREATED);
	}
	
	/*
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
	}
	*/
}
