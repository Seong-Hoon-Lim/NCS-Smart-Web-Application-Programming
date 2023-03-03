package com.kudangtang.jvx330.lifecycle.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.kudangtang.jvx330.lifecycle.example1.ex1.Dog;
import com.kudangtang.jvx330.lifecycle.example1.ex2.Eagle;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype")
	public Hoarse hoarse() {
		return new Hoarse();
	}

}
