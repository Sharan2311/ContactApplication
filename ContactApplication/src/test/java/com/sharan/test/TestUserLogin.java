package com.sharan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharan.config.SpringRootConfig;
import com.sharan.domain.User;
import com.sharan.exception.UserBlockedException;
import com.sharan.service.UserInterface;

public class TestUserLogin {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserInterface userInterface=ctx.getBean(UserInterface.class);
		//the user details will be taken from User-Reg form
        try {
			User u =userInterface.login("naveen", "naveen123");
			System.out.println(u.getEmail());
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("---------Data Saved---------");
	}
}
