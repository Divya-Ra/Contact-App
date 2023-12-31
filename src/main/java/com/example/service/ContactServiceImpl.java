package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;

@Service 
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		
		contact.setActiveSw("Y");
		
		Contact save = contactRepo.save(contact);
		if(save.getContactId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContact() {
		
		return contactRepo.findAll();
	
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
     
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent())
		{
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);
			return true;
			
		}

		return false;
	}
	
	
	

}
