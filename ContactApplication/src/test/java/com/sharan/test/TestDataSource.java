package com.sharan.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sharan.config.SpringRootConfig;

public class TestDataSource {
	
   public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	DataSource ds = ctx.getBean(DataSource.class);
	JdbcTemplate jt = new JdbcTemplate(ds);
	String sql= "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`)VALUES(?,?,?,?,?,?)";
	Object[] param= new Object[] {"Sharan","9008420384","sharan2311@gmail.com","GLB","shan","1234"};
	jt.update(sql, param);
	System.out.println("-------SQL Executed------");
}
}
