package com.proj.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {
//test whether the user instance is created or not
	public static void main(String[] args) {
		//because we used annotations above the domain class
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//will scan the package and check whether any class is there with annotation.
		context.scan("com.proj");
		//will clear the context and create new instance of classe which are there in com.niit package
		//with annotation
		context.refresh();
		//try to get instance of user class
		// it will return instance if it is avilable in bean factory
		//else it will throw error:NoSuchBeanDefinitionException
		context.getBean("user");
		System.out.println("Successfully created instance");
	}
}
