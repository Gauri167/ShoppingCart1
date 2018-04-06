package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDAO;
import com.shop.domain.Cart;

@Controller
public class CartController {
	
	private static final Logger log=LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	
	@PostMapping("/product/cart/add")
	public ModelAndView addToCart(@RequestParam String productName,@RequestParam int price,@RequestParam String quantity)
	{
		log.debug("STarting of addToCart method");
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		if(loggedInUserId.equals(null))
		{
			mv.addObject("errorMessage","please log in to add any product to cart");
			return mv;
		}
		cart.setEmailId(loggedInUserId);
		cart.setPrice(price);
		cart.setQuantity(Integer.parseInt(quantity));
		
		if(cartDAO.save(cart))
		{
			mv.addObject("successMessage","Product added to cart");
		}
		else mv.addObject("errorMessage","Product not added to cart");
		log.debug("ending of addToCart method");
		return mv;
	}
	
	//get my cart details
	@GetMapping("/mycart")
	public ModelAndView getMyCartDetails()
	{
		log.debug("STarting of getMyCartDetails method");
		ModelAndView mv=new ModelAndView("home");
		// it will return all the products which are added to cart
		// this is not correct bcoz we must display only the products that are added by him
		String loggedInUserId= (String) httpSession.getAttribute("loggedInUserId");
		if(loggedInUserId.equals(null))
		{
			mv.addObject("errorMessage","please log in to add any product to cart");
			return mv;
		}
		mv.addObject("isUserClickedMyCart",true);
		List<Cart> cartList=cartDAO.cartlist(loggedInUserId);
		mv.addObject("cartList",cartList);
		log.debug("ending of getMyCartDetails method");
		return mv;
	}
	
	/*@GetMapping("/mycart")
	public ModelAndView myCart()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedMyCart",true);
		return mv;
		
	}*/
}
