package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.AppConstant;
import com.example.entity.Contact;
import com.example.properties.AppProperties;
import com.example.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AppProperties appProp;
	
	@PostMapping(value="/contact")
	public String saveContact(@RequestBody Contact contact)
	{
		
		boolean status = contactService.saveContact(contact);
		
		Map<String, String> messages = appProp.getMessages();
		if(status)
		{
			return messages.get(AppConstant.CONTACT_SAVE_SUCCESS);
		}else
			return messages.get(AppConstant.CONTACT_SAVE_FAIL);
		
	}
	
	@GetMapping(value="/contacts")
	public List<Contact> getAllContact()
	{
		return contactService.getAllContact();
	}
	
	@GetMapping("/contact/{cid}")
	public Contact editContact(@PathVariable("cid")Integer contactId)
	{
		return contactService.getContactById(contactId);
		
	}
	
	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable("cid")Integer contactId)
	{
		
		Map<String, String> messages = appProp.getMessages();
		boolean status = contactService.deleteContactById(contactId);
		if(status) {
			return messages.get(AppConstant.CONTACT_DELETE_SUCCESS);
		}else
			return messages.get(AppConstant.CONTACT_DELETE_FAIL);
	}

}
