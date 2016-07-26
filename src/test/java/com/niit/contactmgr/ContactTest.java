package com.niit.contactmgr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.contactmgr.Dao.ContactDao;
import com.niit.contactmgr.model.Contact;

public class ContactTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.contactmgr");
		context.refresh();
		
		
		ContactDao contactDao= (ContactDao) context.getBean("contactDao");
		
		Contact contact= (Contact) context.getBean("contact");
		contact.setFirstName("Mihir");
		contact.setLastName("Jha");
		contact.setEmail("mihirjha6427.mj@gmail.com");
		contact.setPhone(955);
		contact.setId(1);
		

		contactDao.saveOrUpdate(contact);
		
		
		
		
		
	}

}
