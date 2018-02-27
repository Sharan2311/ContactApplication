package com.sharan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;

public class TestUserDAOUpdate {
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO user = ctx.getBean(UserDAO.class);
	User u = new User();
    u.setUserId(1);
	u.setName("Sharan Reddy");
	u.setLoginStatus(1);
	u.setRole(1);
	user.update(u);
	System.out.println("____USER UPDATED_______");
	}
}
