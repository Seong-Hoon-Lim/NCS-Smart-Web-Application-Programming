package com.kudangtang.jvx330.lifecycle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Goat {
	private static int count;
	
	public Goat() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
						new AnnotationConfigApplicationContext(AppConfig.class);
		Goat goat1 = context.getBean("goat", Goat.class);
		Goat goat2 = context.getBean("goat", Goat.class);
		Goat goat3 = context.getBean("goat", Goat.class);
		
		System.out.println("Goat's count: " + goat1.getCount());
		System.out.println("Goat's count: " + goat2.getCount());
		System.out.println("Goat's count: " + goat3.getCount());
		
		context.close();
		
	}
}
