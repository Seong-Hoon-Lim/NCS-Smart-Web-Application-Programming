package com.kudangtang.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	//byType ���·� ������̼��� ������
	@Autowired
	@Qualifier("sessionCartService")
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService")
	private CartService service2;
	
	public void processRequest() {
		service.addItem();
		service2.addItem();
	}
	
}
