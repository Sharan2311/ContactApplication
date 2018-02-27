package com.sharan.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.ContactDAO;
import com.sharan.dao.UserDAO;
import com.sharan.domain.Contact;
import com.sharan.domain.User;

public class TestContactDAOfindbyProperty {
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	ContactDAO contact = ctx.getBean(ContactDAO.class);
	List<Contact> contacts = contact.findByProperty("userId",2);
	for(Contact u : contacts) {
		System.out.println(u.getEmail());
	}
	}
}
