package com.kudangtang.jvx330.lifecycle.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.close();
	}
}
