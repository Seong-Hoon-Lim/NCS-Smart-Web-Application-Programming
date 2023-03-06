package com.kudangtang.jvx330.jdbc.example2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.kudangtang.jvx330.jdbc.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class Example2Config {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dataSource);
	}
}
