package com.shop.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.CartDAO;
import com.shop.domain.Cart;

public class CartDAOTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;

	@Autowired
	private static Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		cartDAO=(CartDAO) context.getBean("cartDAO");
		cart=(Cart) context.getBean("cart");
	}
	@Ignore
    @Test
	public void saveCartTestCase()
	{
		cart.setEmailId("abcd@gmail.com");
		cart.setPrice(400);
		cart.setProductName("T-Shirts");
		cart.setQuantity(1);
		cart.setProductid("Kids-002");
		boolean status=cartDAO.save(cart);
		assertTrue("saveCartTestCase",status);
	}
    
   /* @Test
    public void deleteCartTestCase() {
    	 int id=cart.getId();
        boolean status=cartDAO.delete(id);
    }*/

}
