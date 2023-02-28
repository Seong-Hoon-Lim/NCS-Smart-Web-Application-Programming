package com.kudangtang.jvx330.di.example5.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/kudangtang/jvx330/di/example5/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		MemberController memberController = 
				context.getBean("memberController", MemberController.class);
		
		memberController.addMember("java", "1111");
		context.close();
		
	}
}
