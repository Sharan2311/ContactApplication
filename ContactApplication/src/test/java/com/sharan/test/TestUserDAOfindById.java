package com.sharan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;

public class TestUserDAOfindById {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO user = ctx.getBean(UserDAO.class);
		User u =user.findById(3);
		System.out.println("USER EMAIL");
		System.out.println(u.getEmail());
	}

}
