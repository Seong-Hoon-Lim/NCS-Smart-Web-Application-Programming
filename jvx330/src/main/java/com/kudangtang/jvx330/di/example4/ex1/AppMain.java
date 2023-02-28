package com.kudangtang.jvx330.di.example4.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/kudangtang/jvx330/di/example4/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		ByNameClient byNameClient = context.getBean("byNameClient", ByNameClient.class);
		byNameClient.service("myQueue");
		context.close();
	}
}
