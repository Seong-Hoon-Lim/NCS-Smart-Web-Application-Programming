package com.kudangtang.jvx330.jdbc.example1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.kudangtang.jvx330.jdbc.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)	//Example1Config 클래스가 생성될 때 DataSourceConfig.class import 해옴
public class Example1Config {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public AddCustomerDataSourceDao addCustomerDataSourceDao() {
		return new AddCustomerDataSourceDao(dataSource);
	}
	
	@Bean
	public AddCustomerDao addCustomerDao() {
		return new AddCustomerDao(dataSource);
	}
}
