package com.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proj.dao.UserDAO;
import com.proj.domain.User;

@Controller
public class UserController {
	//UserDAO-backend project  is used to validate
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;
	//will send user id and password from jsp to controller
	//it should validate the credentials
	//it should return username---valid credentials
	//it should return error---invalid credentials
	@RequestMapping("validate")//refers to post method
 public ModelAndView validate(@RequestParam("uname") String username,@RequestParam("psw") String password)
 {
		ModelAndView mv=new ModelAndView("home");
		user=userDAO.validate(username, password);
	   if( user==null)
	   {
		   //invalid credentials
		   mv.addObject("errorMessage", "Invalid Id or Password........Please try again");
	   }
	   else {
		   //valid credentials
		   mv.addObject("welcomeMessage","Welcome"+user.getName());
	   }
	 return mv;
 }
}
