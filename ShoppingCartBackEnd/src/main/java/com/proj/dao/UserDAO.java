package com.proj.dao;

import java.util.List;

import com.proj.domain.User;
//DAO->Data Access Object
public interface UserDAO {
//declare the method
	//create new user
	public boolean save(User user);
	//update
	public boolean update(User user);
	//get details
	public User get(String emailId);
	//delete the user
	public boolean delete(String emailId);
	//
	public List<User> list();
	public User validate(String emailId,String password);
	
}
