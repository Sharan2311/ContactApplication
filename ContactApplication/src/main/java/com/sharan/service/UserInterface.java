package com.sharan.service;

import java.util.List;

import com.sharan.domain.User;
import com.sharan.exception.UserBlockedException;

public interface UserInterface {
	public static final Integer loginStatus_Active=1;
	public static final Integer loginStatus_Blocked=2;
	
	public static final Integer role_admin=1;
	public static final Integer role_user=2;
	/**
	 * The method handles user registration and it saves the user details to DB
	 * @param u
	 */
	public void register(User u);
	/**
	 * The method handles login (authentication) using given credentials, it returns user object and returns null if failed.
	 * the userblocked exception is thrown when user account is blocked 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	/**
	 * For the admin to see the list of users
	 * @return
	 */
	public List<User> getUserList();
	/**
	 * This method change the user login status to either active or Blocked by the admin
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
		
	

}
