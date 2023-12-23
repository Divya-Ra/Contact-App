package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Contact;


public interface ContactService {
	
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer contactId);
	
	public boolean deleteContactById(Integer contactId);
	
	

}
