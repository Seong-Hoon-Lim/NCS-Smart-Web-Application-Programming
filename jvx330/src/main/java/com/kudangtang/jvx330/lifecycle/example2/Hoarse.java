package com.kudangtang.jvx330.lifecycle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Hoarse {
	private static int count;
	private int serialNum;
	
	public Hoarse() {
		this.serialNum = count;
//		System.out.println("Hoarse's serialNum : " + serialNum);
	}
	
	public static int getCount() {
		return count;
	}
	
	public int getSerialNum() {
		return serialNum;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
						new AnnotationConfigApplicationContext(AppConfig.class);
		Hoarse hoarse1 = context.getBean("hoarse", Hoarse.class);
		Hoarse hoarse2 = context.getBean("hoarse", Hoarse.class);
		Hoarse hoarse3 = context.getBean("hoarse", Hoarse.class);
		System.out.println("hoarse1 serialNum : " + hoarse1.getSerialNum());
		System.out.println("hoarse1 serialNum : " + hoarse2.getSerialNum());
		System.out.println("hoarse1 serialNum : " + hoarse3.getSerialNum());
		
		System.out.println("Hoarse's count: " + Hoarse.getCount());
		
		context.close();
		
	}

}
