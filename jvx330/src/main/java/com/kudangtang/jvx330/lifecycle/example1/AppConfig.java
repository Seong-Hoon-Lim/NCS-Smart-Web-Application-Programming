package com.kudangtang.jvx330.lifecycle.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kudangtang.jvx330.lifecycle.example1.ex1.Dog;

@Configuration
public class AppConfig {
	
	@Bean
	public Dog dog() {
//		dog().setName("��Ʈ");
		Dog d = new Dog("����");
		d.setName("��Ʈ");
		return d;
	}
}
