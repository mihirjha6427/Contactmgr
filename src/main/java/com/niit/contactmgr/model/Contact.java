package com.niit.contactmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("contact")
public class Contact {
	@Id
	
	int id;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String email;
	@Column
	int phone;
	
	
	public Contact(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int i) {
		this.phone = i;
	}
	
	

}
