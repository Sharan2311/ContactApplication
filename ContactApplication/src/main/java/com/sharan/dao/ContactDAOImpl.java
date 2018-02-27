package com.sharan.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sharan.domain.Contact;
import com.sharan.domain.User;
import com.sharan.rm.ContactRowMapper;
import com.sharan.rm.UserRowMapper;
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public void save(Contact c) {
		String sql= "INSERT INTO contact(userId, name, phone, email, address, remark)" +
                "VALUES(:userId, :name, :phone, :email, :address, :remark)";
	Map m = new HashMap();
	m.put("userId", c.getUserId());
	m.put("name", c.getName());
	m.put("phone", c.getPhone());
	m.put("email", c.getEmail());
	m.put("address", c.getAddress());
	m.put("remark", c.getRemark());
	
	KeyHolder kh = new GeneratedKeyHolder();
	SqlParameterSource ps = new MapSqlParameterSource(m);
	super.getNamedParameterJdbcTemplate().update(sql, ps,kh);
	Integer contactId = kh.getKey().intValue();
	c.setContactId(contactId);
		
	}

	public void update(Contact c) {
		String Sql= "UPDATE contact"
	               +" SET name=:name, "
				+"phone= :phone, "
		        +"email= :email, "
				+"address= :address, "
		        +"remark= :remark,"
				+" WHERE contactId= :contactId ";
		Map m = new HashMap();
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		m.put("contactId", c.getContactId());
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(Sql, ps);
		
	}

	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer contactId) {
		String sql = "DELETE FROM contact WHERE contactId=?";
		getJdbcTemplate().update(sql,contactId);
		
	}

	public Contact findById(Integer contactId) {
		String sql = "SELECT contactId,name,phone,email,address,remark " + " FROM contact WHERE contactId=?";
		Contact c =getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),contactId);
		return c;
	}

	public List<Contact> findAll() {
		String sql = "SELECT contactId,name,phone,email,address,remark" + " FROM contact";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql = "SELECT contactId,userId,name,phone,email,address,remark" + " FROM contact WHERE "+propName+" =?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue);
	}

}
