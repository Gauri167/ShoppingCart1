<<<<<<< HEAD
package com.proj.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.dao.UserDAO;
import com.proj.domain.User;
@Repository("userDAO")//will create instance and name will be userDAOImpl
           // to change instance name write it in()
public class UserDAOImpl implements UserDAO{
	@Autowired//session factory will automatically inject in this class
private SessionFactory sessionFactory;
	@Autowired
	private User user;
	
	@Transactional
	public boolean save(User user) {
		// Store in database
		try {
		sessionFactory.getCurrentSession().save(user);
		return true;
		} catch(HibernateException e) {
			System.out.println("Exception="+e);
		return false;}
		
	}

	/* (non-Javadoc)
	 * @see com.proj.shoppingcart.dao.UserDAO#update(com.proj.shoppingcart.domain.User)
	 */

	@Transactional
	public boolean update(User user) {
		try {
			if(get(user.getEmailId())==null) { return false;}
		sessionFactory.getCurrentSession().update(user);
		return true;
	}catch(HibernateException e) {
		return false;}
		
	}

	@Transactional
	public User get(String emailId) {
		// Fetch the record based on emailId and store in User class
		try {
		return sessionFactory.getCurrentSession().get(User.class, emailId);}
		catch(HibernateException e) {
			return null;}
		
		}

	@Transactional
	public boolean delete(String emailId) {
		//delete method takes onlly object whereas emailId is a parameter
		//so we write delete(get(emailId)); 
		//the get() method will give the object
		try {
			user=get(emailId);
			if(user==null) {return false;}
		sessionFactory.getCurrentSession().delete(user);
		return true;}
	catch(HibernateException e) {
			return false;}
		
		}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from user").list();
	}

	@SuppressWarnings("deprecation")
	public User validate(String emailId, String password) {
		//select * from user where emailId='user@gamil.com' and password='user@123'
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).
		add(Restrictions.eq("emailId", emailId)).
		add(Restrictions.eqOrIsNull("Password", password)).uniqueResult();
	}
	

	}
	
=======
package com.proj.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.dao.UserDAO;
import com.proj.domain.User;
@Repository("userDAO")//will create instance and name will be userDAOImpl
           // to change instance name write it in()
public class UserDAOImpl implements UserDAO{
	@Autowired//session factory will automatically inject in this class
private SessionFactory sessionFactory;
	@Autowired
	private User user;
	
	@Transactional
	public boolean save(User user) {
		// Store in database
		try {
		sessionFactory.getCurrentSession().save(user);
		return true;
		} catch(HibernateException e) {
			System.out.println("Exception="+e);
		return false;}
		
	}

	/* (non-Javadoc)
	 * @see com.proj.shoppingcart.dao.UserDAO#update(com.proj.shoppingcart.domain.User)
	 */

	@Transactional
	public boolean update(User user) {
		try {
			if(get(user.getEmailId())==null) { return false;}
		sessionFactory.getCurrentSession().update(user);
		return true;
	}catch(HibernateException e) {
		return false;}
		
	}

	@Transactional
	public User get(String emailId) {
		// Fetch the record based on emailId and store in User class
		try {
		return sessionFactory.getCurrentSession().get(User.class, emailId);}
		catch(HibernateException e) {
			return null;}
		
		}

	@Transactional
	public boolean delete(String emailId) {
		//delete method takes onlly object whereas emailId is a parameter
		//so we write delete(get(emailId)); 
		//the get() method will give the object
		try {
			user=get(emailId);
			if(user==null) {return false;}
		sessionFactory.getCurrentSession().delete(user);
		return true;}
	catch(HibernateException e) {
			return false;}
		
		}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from user").list();
	}

	@SuppressWarnings("deprecation")
	public User validate(String emailId, String password) {
		//select * from user where emailId='user@gamil.com' and password='user@123'
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).
		add(Restrictions.eq("emailId", emailId)).
		add(Restrictions.eqOrIsNull("Password", password)).uniqueResult();
	}
	

	}
	
>>>>>>> ae6bd7aa61bf52b0302bbe696bf8804ed583d05b
