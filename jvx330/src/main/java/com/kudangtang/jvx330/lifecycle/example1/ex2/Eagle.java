package com.kudangtang.jvx330.lifecycle.example1.ex2;

public class Eagle {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void attachWings() {
		System.err.println("initMethod ȣ�� : �����ޱ�");
	}
	
	public void detachWings() {
		System.out.println("destoryMethod ȣ�� : ����ȸ��");
	}
}
