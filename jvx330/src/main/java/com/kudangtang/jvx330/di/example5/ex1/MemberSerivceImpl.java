package com.kudangtang.jvx330.di.example5.ex1;

public class MemberSerivceImpl implements MemberService {

	@Override
	public void addMember(String id, String passwd) {
		// TODO Auto-generated method stub
		System.out.println("new member inserted : " + id + "/" + passwd);
	}
	
}
