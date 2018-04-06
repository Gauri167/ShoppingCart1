<<<<<<< HEAD
package com.proj.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proj.dao.UserDAO;
import com.proj.domain.User;

public class UserDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDAO userDAO;
	@Autowired
	private static User user;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		//scans all the packages for annotations like @component,repository,etc
		context.scan("com.proj");
		//refreshes 
		context.refresh();
		//ask the context to get the instance
		// type casting is done bcoz it is giving an object but we need it for user dao
		userDAO=(UserDAO) context.getBean("userDAO");
		user=(User) context.getBean("user");
	}
	
	@Ignore
	@Test
	public void saveUserTestCase() {
		user=new User();
		user.setEmailId("abxy@gmail.com");
		user.setMobile("1234567");
		user.setName("Abcd Abcd");
		user.setRole('u');
		user.setPassword("abcd@123");
		Date ndate=new Date();
		user.setRegisterDate(ndate);
		boolean status=userDAO.save(user);
		assertTrue("save user test case fail",status);
	}
	
	@Ignore
	@Test
	public void updateUserTestCase()
	{
		user.setEmailId("abcd1@gmail.com");
		user.setMobile("8888888888");
		boolean status=userDAO.update(user);
		assertEquals("update test case",true,status);
	}
	
	@Ignore
	@Test
	public void getUserTestCase()
	{
		user=userDAO.get("niit@gmail.com");
		assertNotNull("get user tst case",user);
	}
    
	@Ignore
	@Test
	public void deleteUserSuccessTestCAse()
	{
		boolean status=userDAO.delete("user@gamil.com");
		assertTrue("delete user success test case",status);
	}
	
	@Ignore
	@Test
	public void deleteUserFailureTestCAse()
	{
		boolean status=userDAO.delete("niit@gmail.com");
		assertEquals("delete user failure test case",false,status);
	}
	
	@Ignore
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users= userDAO.list();
		assertEquals("get all users",8,users.size());
	}
	
	@Ignore
	@Test
	public void validateCredentialsTestCase()
	{
		user=userDAO.validate("abcd1@gamil.com"," abcd@123");
		assertNotNull("Validate Test Case",user);
		
	}
}
=======
package com.proj.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proj.dao.UserDAO;
import com.proj.domain.User;

public class UserDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDAO userDAO;
	@Autowired
	private static User user;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		//scans all the packages for annotations like @component,repository,etc
		context.scan("com.proj");
		//refreshes 
		context.refresh();
		//ask the context to get the instance
		// type casting is done bcoz it is giving an object but we need it for user dao
		userDAO=(UserDAO) context.getBean("userDAO");
		user=(User) context.getBean("user");
	}
	
	@Ignore
	@Test
	public void saveUserTestCase() {
		user=new User();
		user.setEmailId("abxy@gmail.com");
		user.setMobile("1234567");
		user.setName("Abcd Abcd");
		user.setRole('u');
		user.setPassword("abcd@123");
		Date ndate=new Date();
		user.setRegisterDate(ndate);
		boolean status=userDAO.save(user);
		assertTrue("save user test case fail",status);
	}
	
	@Ignore
	@Test
	public void updateUserTestCase()
	{
		user.setEmailId("abcd1@gmail.com");
		user.setMobile("8888888888");
		boolean status=userDAO.update(user);
		assertEquals("update test case",true,status);
	}
	
	@Ignore
	@Test
	public void getUserTestCase()
	{
		user=userDAO.get("niit@gmail.com");
		assertNotNull("get user tst case",user);
	}
    
	@Ignore
	@Test
	public void deleteUserSuccessTestCAse()
	{
		boolean status=userDAO.delete("user@gamil.com");
		assertTrue("delete user success test case",status);
	}
	
	@Ignore
	@Test
	public void deleteUserFailureTestCAse()
	{
		boolean status=userDAO.delete("niit@gmail.com");
		assertEquals("delete user failure test case",false,status);
	}
	
	@Ignore
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users= userDAO.list();
		assertEquals("get all users",8,users.size());
	}
	
	@Ignore
	@Test
	public void validateCredentialsTestCase()
	{
		user=userDAO.validate("abcd1@gamil.com"," abcd@123");
		assertNotNull("Validate Test Case",user);
		
	}
}
>>>>>>> ae6bd7aa61bf52b0302bbe696bf8804ed583d05b
