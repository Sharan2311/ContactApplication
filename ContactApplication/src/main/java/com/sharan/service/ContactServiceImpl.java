package com.sharan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sharan.dao.BaseDAO;
import com.sharan.dao.ContactDAO;
import com.sharan.domain.Contact;
import com.sharan.rm.ContactRowMapper;
import com.sharan.util.Stringutility;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactInterface {
	@Autowired
   private ContactDAO contactDAO;
	public void save(Contact c) {
	
		contactDAO.save(c);
	}

	public void update(Contact c) {
		contactDAO.update(c);
		
	}

	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
		
	}

	public void delete(Integer[] contactIds) {
		String Ids = Stringutility.toCommaSeperatedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN("+Ids+")";
		getJdbcTemplate().update(sql);
	}

	public List<Contact> findUserContact(Integer userId) {
		
		
		return contactDAO.findByProperty("userId",userId);
	}

	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "SELECT contactId,name,phone,email,address,remark" + " FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%'  OR email LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),userId);
	}

}
