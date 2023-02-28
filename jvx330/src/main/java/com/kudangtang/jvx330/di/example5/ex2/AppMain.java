package com.kudangtang.jvx330.di.example5.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/kudangtang/jvx330/di/example5/ex2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		CartController cartController = 
				context.getBean("cartController", CartController.class);
		
		cartController.processRequest();
		context.close();
		
	}
}
