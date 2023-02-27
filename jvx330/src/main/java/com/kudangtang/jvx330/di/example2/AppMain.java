package com.kudangtang.jvx330.di.example2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config = "com/kudangtang/jvx330/di/example2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		//생성자 방식 DI
//		Foo foo = context.getBean("constructor-foo", Foo.class);
		
		//프라퍼티 방식 DI(아규먼트가 없는 생성자가 반드시 존재해야함)
		Employee e = context.getBean("employee", Employee.class);
		System.out.println(e);
		
		context.close();
		
	}

}
