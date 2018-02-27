package com.sharan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sharan.dao.BaseDAO;
import com.sharan.dao.UserDAO;
import com.sharan.domain.User;
import com.sharan.exception.UserBlockedException;
import com.sharan.rm.UserRowMapper;
@Service
public class UserServiceImpl extends BaseDAO implements UserInterface{
	@Autowired
    private UserDAO userDAO;

	public void register(User u) {
		userDAO.save(u);
		
	}

	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId,name,phone,email,address,loginName,role,loginStatus" + " FROM user WHERE LoginName= :ln AND password= :pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
		User u =getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
		if(u.getLoginStatus().equals(UserInterface.loginStatus_Blocked)) {
			throw new UserBlockedException("your account has been Blocked Contact Admin");
		}else {
		return u;
		}
		}catch(EmptyResultDataAccessException e) {
		
		return null;
		}
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}


}
