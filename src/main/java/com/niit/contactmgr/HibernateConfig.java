package com.niit.contactmgr;

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


import com.niit.contactmgr.Dao.ContactDao;
import com.niit.contactmgr.Dao.ContactDaoimpl;
import com.niit.contactmgr.model.Contact;


@Configuration
@ComponentScan("com.niit.contactmgr")
@EnableTransactionManagement
public class HibernateConfig {
	
	

		
		
		
		@Bean(name="dataSource")
		public DataSource getH2DataSource(){
			DriverManagerDataSource dataSource= new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/contact");
			
			dataSource.setUsername("niit");
			dataSource.setPassword("niit");
			return dataSource;
		}
		
		private Properties getHibernateProperties(){
			Properties properties= new Properties();
			properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.show_sql","true");
			
			
			return properties;
			
		}
		
		@Autowired
		
		@Bean(name="sessionFactory")
		
		public SessionFactory getSessionFactory(DataSource dataSource){
			LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClasses(Contact.class);
			
			return sessionBuilder.buildSessionFactory();
		}
		@Autowired
		
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
			
			return transactionManager;
		}
		
		@Autowired
		@Bean (name="contactDao")
		 public ContactDao getcontactDAO(SessionFactory sessionFactory) {
	        
	        return new ContactDaoimpl(sessionFactory);}
}
