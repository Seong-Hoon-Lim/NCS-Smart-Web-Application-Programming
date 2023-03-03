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
		System.err.println("initMethod 호출 : 날개달기");
	}
	
	public void detachWings() {
		System.out.println("destoryMethod 호출 : 날개회수");
	}
}
