package com.kudangtang.jvx330.di.example5.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
	
	@Autowired
	private MemberService memberSerivce;
	
	public void addMember(String id, String passwd) {
		memberSerivce.addMember(id, passwd);
		
	}
}
