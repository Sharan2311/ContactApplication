package com.sharan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharan.command.ContactCommand;
import com.sharan.domain.Contact;
import com.sharan.service.ContactInterface;

@Controller
public class ContactController {
	@Autowired
	ContactInterface contactinterface;
	@RequestMapping(value="/contact_form")
public String addContact(Model m) {
		m.addAttribute("command", new ContactCommand());
		return "addContact";
	}
	@RequestMapping(value="/contact")
	public String Contactaddition(@ModelAttribute("command") ContactCommand cmd,HttpSession session) {
		Contact c = cmd.getContact();
		Integer userId = (Integer) session.getAttribute("userId");
		c.setUserId(userId);
		contactinterface.save(c);
		return "redirect:/contactlist_form";
		
	}
	
	@RequestMapping(value="/contactlist_form")
public String listContact(Model m,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println(userId);
		m.addAttribute("contactlist", contactinterface.findUserContact(userId));
		return "listcontact";
	}

}
