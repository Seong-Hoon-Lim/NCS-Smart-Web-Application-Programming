package com.kudangtang.jvx330.lifecycle.example1.ex1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dog implements InitializingBean, DisposableBean {
	private String name;
	
	public Dog() {
		System.out.println("������1");
	}
	
	public Dog(String name) {
		System.out.println("������2");
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
	 *	bean �� set �ǰ� �� �� ����Ǵ� �޼ҵ�
	 *	(property �� ���� �ǰ� �� ���Ŀ� ����� �޼ҵ�)
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
	 * bean �� ���� �Ǳ� ������ ����Ǵ� �޼ҵ�
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy() ȣ��");
		
		
	}

}
