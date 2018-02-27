package com.sharan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;
import com.sharan.service.UserInterface;

public class TestUserServiceRegister {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserInterface userInterface=ctx.getBean(UserInterface.class);
		//the user details will be taken from User-Reg form
		User u = new User();
		u.setName("Maheshwar");
		System.out.println("i am here");
		u.setPhone("8150870448");
		u.setEmail("Maheshwar@gmail.com");
		u.setAddress("GLB");
		u.setLoginName("mahesh1");
		u.setPassword("mahesh123");
        u.setRole(userInterface.role_user);//AdminRole
        u.setLoginStatus(userInterface.loginStatus_Active);//Active
        userInterface.register(u);
        System.out.println("---------Data Saved---------");
	}
    
    
}
