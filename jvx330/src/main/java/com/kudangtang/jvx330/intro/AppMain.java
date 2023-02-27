package com.kudangtang.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config = "com/kudangtang/jvx330/intro/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		Hello hello = context.getBean("helloBean", Hello.class);
		System.out.println(hello.sayHello("Spring"));
		
		
		Hello hello2 = (Hello)context.getBean("helloBean2");
		System.out.println(hello2.sayHello("Spring"));
		context.close();

	}

}
