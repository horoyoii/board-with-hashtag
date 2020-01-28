package com.horoyoii.mvcexam.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.horoyoii.mvcexam.dao.UserDaoImpl;
import com.horoyoii.mvcexam.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user") 
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    BasicDataSource dataSource;
    
    @Autowired 
    UserDaoImpl userDaoImpl;
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Locale locale, Model model) {
		logger.info("Welcome user! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "user";
	}

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView userTest(HttpServletRequest request) {
		int uid = Integer.valueOf(request.getParameter("uid"));
		
		ModelAndView mv = new ModelAndView("/user");
		
		User user = userDaoImpl.getByUid(uid);
        
		mv.addObject("user",user.getName());
		
		return mv;
	}	
}