package com.kudangtang.jvx330.di.example6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		/**
		 * .xml 파일을 사용할 때
		 */
		String config = "com/kudangtang/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = 
					new GenericXmlApplicationContext(config);
		
//		GenericApplicationContext context = 
//					new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = context.getBean("memberService", MemberService.class);
		
		for (Member member : memberService.getMemberList()) {
			System.out.println(member);
		}
		context.close();
	}
}
