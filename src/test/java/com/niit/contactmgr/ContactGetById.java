package com.niit.contactmgr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.contactmgr.Dao.ContactDao;

public class ContactGetById {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.contactmgr");
		context.refresh();
		
		
		ContactDao contactDao= (ContactDao) context.getBean("contactDao");
		
		
		
		

		contactDao.getById(1);

}}
