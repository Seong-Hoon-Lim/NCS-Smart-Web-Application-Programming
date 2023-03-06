package com.kudangtang.jvx330.jdbc.example5;

import javax.sql.DataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.kudangtang.jvx330.jdbc.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages = "com.kudangtang.jvx330.jdbc.example5")
public class Example5Config {
	
}
