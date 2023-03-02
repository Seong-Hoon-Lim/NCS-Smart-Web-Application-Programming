package com.kudangtang.jvx330.lifecycle.example1.ex1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dog implements InitializingBean, DisposableBean {
	private String name;
	
	public Dog() {
		System.out.println("생성자1");
	}
	
	public Dog(String name) {
		System.out.println("생성자2");
		this.name = name;
	}
	
	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	/**
	 *	bean 이 set 되고 난 후 실행되는 메소드
	 *	(property 가 세팅 되고 난 이후에 실행될 메소드)
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet");
		if (this.name == null) {
			System.out.println("Property name must be set.");
		}
		else {
			System.out.println(this.name);
		}
		
	}
	/**
	 * bean 이 제거 되기 직전에 실행되는 메소드
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출");
		
		
	}

}
