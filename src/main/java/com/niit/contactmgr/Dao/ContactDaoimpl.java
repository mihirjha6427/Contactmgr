package com.niit.contactmgr.Dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.contactmgr.model.Contact;

@Repository("contactDao")
public class ContactDaoimpl implements ContactDao {
@Autowired
private SessionFactory sessionFactory;
public ContactDaoimpl(SessionFactory sessionFactory){
	this.sessionFactory= sessionFactory;
}
@SuppressWarnings({ "deprecation", "unchecked" })
@Transactional	

	public List<Contact> ListAll() {
		
		Session session= sessionFactory.openSession();
		List<Contact> contacts= session.createCriteria(Contact.class).list();
		session.close();
		return contacts;
	}
@Transactional
	public void saveOrUpdate(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	
		
	}
@Transactional
	public void delete(int id) {
	Contact contactToDelete= new Contact();
	contactToDelete.setId(id);
		
		sessionFactory.getCurrentSession().delete(contactToDelete);
		
	}

	public Contact getById(int id) {
		Session session= sessionFactory.openSession();
		Contact contact= session.get(Contact.class, id);
		session.close();
		return contact;
		}
		
	
	}


