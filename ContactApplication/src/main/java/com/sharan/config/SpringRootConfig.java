package com.sharan.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.sharan.dao","com.sharan.service"})
public class SpringRootConfig {
	@Bean
    public BasicDataSource getdataSource() {
	BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/contactapplication_db");
	ds.setUsername("root");
	ds.setPassword("");
	ds.setMaxTotal(2);
	ds.setInitialSize(1);
	ds.setTestOnBorrow(true);
	ds.setValidationQuery("SELECT 1");
	ds.setDefaultAutoCommit(true);
	return ds;
}
}
