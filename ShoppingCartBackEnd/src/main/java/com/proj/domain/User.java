package com.proj.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//whenever it scans all the classes under a particular package will create instance of this class
@Component//to create instance;instance name is same as class name but first letter will be small letter
@Entity//to specify it is not normal class-it is DB entity
@Table(name="user")//to specify where to map
public class User {
	@Id//to specify it is primary key
	private String emailId;
	@Column(name="Name")
	private String name;
	@Column(name="Password")//to specify which column to map
	//use this anotation only if name in DB and class are diff else no need to use
	private String password;
	@Column(name="Mobile")
	private String mobile;
	@Column(name="Role")
	private char role;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Column(name="RegisterDate")
	private Date registerDate;
	
}
