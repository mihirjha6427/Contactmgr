package com.niit.contactmgr;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.contactmgr.Dao.ContactDao;
import com.niit.contactmgr.model.Contact;

import javassist.bytecode.Descriptor.Iterator;

public class ContactList {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.contactmgr");
		context.refresh();
		
		
		ContactDao contactDao= (ContactDao) context.getBean("contactDao");
		
		List<Contact> contacts= contactDao.ListAll();
		Iterator itr= (Iterator) contacts.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		

		
		
}
}