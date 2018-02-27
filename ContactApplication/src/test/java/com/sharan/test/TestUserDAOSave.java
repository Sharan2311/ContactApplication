package com.sharan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		//the user details will be taken from User-Reg form
		User u = new User();
		u.setName("Shwetha");
		System.out.println("i am here");
		u.setPhone("8150870447");
		u.setEmail("shwetha@gmail.com");
		u.setAddress("GLB");
		u.setLoginName("shwetha1");
		u.setPassword("shwetha123");
        u.setRole(1);//AdminRole
        u.setLoginStatus(1);//Active
        userDAO.save(u);
        System.out.println("---------Data Saved---------");
	}

}
