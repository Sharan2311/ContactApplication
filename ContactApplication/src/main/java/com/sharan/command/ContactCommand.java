package com.sharan.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharan.domain.Contact;

public class ContactCommand {
	
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
