<<<<<<< HEAD
package com.proj.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.proj.dao.UserDAO;
import com.proj.daoimpl.UserDAOImpl;
import com.proj.domain.User;


@Configuration
@ComponentScan("com.proj.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig {
@Bean(name="dataSource")
public DataSource getDataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/shoppincartdbdemo");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	return dataSource;
}
private Properties getHibernateProperties()
{
	Properties properties=new Properties();
	properties.put("hibernate.show_sql","true");
	properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.hbm2ddl.auto","update");
	return properties;
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(User.class);
	return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	return transactionManager;
}

@Autowired
@Bean("userDAO")
public UserDAO getUserDAO()
{
	return new UserDAOImpl();
}


}
=======
package com.proj.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.proj.dao.UserDAO;
import com.proj.daoimpl.UserDAOImpl;
import com.proj.domain.User;


@Configuration
@ComponentScan("com.proj.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig {
@Bean(name="dataSource")
public DataSource getDataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/shoppincartdbdemo");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	return dataSource;
}
private Properties getHibernateProperties()
{
	Properties properties=new Properties();
	properties.put("hibernate.show_sql","true");
	properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.hbm2ddl.auto","update");
	return properties;
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(User.class);
	return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	return transactionManager;
}

@Autowired
@Bean("userDAO")
public UserDAO getUserDAO()
{
	return new UserDAOImpl();
}


}
>>>>>>> ae6bd7aa61bf52b0302bbe696bf8804ed583d05b
