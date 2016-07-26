package com.niit.contactmgr.Dao;

import java.util.List;

import com.niit.contactmgr.model.Contact;

public interface ContactDao {
	public List<Contact> ListAll();
	public void saveOrUpdate(Contact contact);
	public void delete(int id);
	public Contact getById(int id);
	

}
