package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Controller
public class HomeController {

	private static final Logger log=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	//private static String rootPath=System.getProperty("catalina.home");
	//private static final String imageDirectory="ShoppingCartImages";
	//private static String rootPath="resources//images";
	private static String rootpath="C:\\Users\\Gauri Gaur\\eclipse-workspace\\ECommProject2\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images\\productImages";
	//private static String imageDirectory="resources"+File.separator+"images";
	@RequestMapping("/")
	public ModelAndView home() {
		
		log.debug("Starting of home Method");
		ModelAndView mv=new ModelAndView("home");
		//httpSession.setAttribute("welcomeMessage","Welcome");
		List<Category> categories=categoryDAO.categorylist();
		httpSession.setAttribute("categories",categories);
		httpSession.setAttribute("rootpath",rootpath);
		//String path=httpSession.getServletContext().getContextPath();
		//System.out.println(imageDirectory);
		
		log.debug("ending of home Method");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		log.debug("Starting of login Method");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedLogin",true);
		log.debug("ending of login Method");
		return mv;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		
		log.debug("Starting of signUp Method");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedSignUp",true);
		log.debug("Ending of SignUp Method");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout()
	{
		log.debug("Starting of logout Method");
		//at time of login we added user in http session
		//at time of logout we need to remove it 
		ModelAndView mv=new ModelAndView("home");
		//we are not able to see menu items after logout
		// we need to modify this code
		httpSession.invalidate();
		/*httpSession.removeAttribute("loggedInUserId");
		httpSession.removeAttribute("isAdmin");*/
		mv.addObject("logoutMessage","You are Successfully Logged Out");
		log.debug("ending of logout Method");
		return mv;
	}
}
