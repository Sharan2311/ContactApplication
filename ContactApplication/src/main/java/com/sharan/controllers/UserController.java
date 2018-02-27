package com.sharan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sharan.command.LoginCommand;
import com.sharan.command.UserCommand;
import com.sharan.domain.User;
import com.sharan.exception.UserBlockedException;
import com.sharan.service.UserInterface;

@Controller
public class UserController {
	@Autowired
	UserInterface userInterface;
	@RequestMapping(value= {"/","/index"})
public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
	return "index";
}
	@RequestMapping(value= "/login", method = RequestMethod.POST)
public String handleLogin(@ModelAttribute("command") LoginCommand cmd , Model m, HttpSession session) {
		try {
			User LoggedIn= userInterface.login(cmd.getLoginName(), cmd.getPassword());
			if(LoggedIn == null) {
				//ERROR 
				m.addAttribute("err","ENTER VALID CREDENTIALS");
				return "index";
			}
			else {
				//SUCCESS
				//Check the role and redirect to the appropriate page
				if(LoggedIn.getRole().equals(userInterface.role_admin)) {
					addLoggedInUsertoSession(LoggedIn, session);
					return "redirect:admin/dashboard";
				}else if(LoggedIn.getRole().equals(userInterface.role_user)) {
					addLoggedInUsertoSession(LoggedIn, session);
					return "redirect:user/dashboard";
				}else {
					m.addAttribute("err", "INVALID USER ROLE");
					return "index";
				}
			}
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			m.addAttribute("err", e.getMessage());
			return "index";
		}
		
}
	@RequestMapping(value= {"/user/dashboard"})
public String userDashboard() {
	return "dashboard";
}
	@RequestMapping(value= {"/admin/dashboard"})
public String adminDashboard() {
	return "dashboard_admin";
}
	@RequestMapping(value= {"/reg_form"})
public String regidtrationForm(Model m) {
		//TODO command
		m.addAttribute("command", new UserCommand());
	return "reg_form";
}
	@RequestMapping(value= {"/register"})
public String regidtration(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(userInterface.role_user);
			user.setLoginStatus(userInterface.loginStatus_Active);
			userInterface.register(user);
return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		m.addAttribute("err", "Username already exists Please give a different username");
		return "reg_form";
		}
}
	
	@RequestMapping(value= {"/home"})
public String home(Model m) {
	return "redirect:/contactlist_form";
}
	@RequestMapping(value= {"/logout"})
public String logOut(HttpSession session) {
		session.invalidate();
	return "redirect:index?act=lo";
}
	public void addLoggedInUsertoSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
}
