package com.kudangtang.jvx330.di.example4.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/kudangtang/jvx330/di/example4/ex2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		ByTypeClient byTypeClient = context.getBean("byTypeClient", ByTypeClient.class);
		byTypeClient.service("myQueue");
		context.close();
	}
}
