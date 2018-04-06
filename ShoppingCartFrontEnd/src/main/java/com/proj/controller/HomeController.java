package com.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//first add spring web mvc
public class HomeController {
   
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("home");
		//add data to mv
		mv.addObject("username","abc");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;
	}
	@RequestMapping("/registration")
	public ModelAndView registration()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;
	}
}
