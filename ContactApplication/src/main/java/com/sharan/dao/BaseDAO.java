package com.sharan.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
//NOTE: DO NOT USE @Repository or @Component annotation because BaseDAO will exist independently in your IOC container
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
	@Autowired
public void setDataSource2(DataSource ds) {
	super.setDataSource(ds);
}
}
