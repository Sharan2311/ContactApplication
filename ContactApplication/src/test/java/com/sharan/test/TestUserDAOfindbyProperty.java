package com.sharan.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;

public class TestUserDAOfindbyProperty {
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO user = ctx.getBean(UserDAO.class);
	List<User> users = user.findByProperty("name","madhu");
	for(User u : users) {
		System.out.println(u.getEmail());
	}
	}
}
