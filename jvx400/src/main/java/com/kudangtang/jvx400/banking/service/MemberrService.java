package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.vo.Member;

public interface MemberrService {
	
	public void signupMember(Member member);
	
	public Member loginMember(String email, String passwd);
	
	public Member myPage(String email);
	
	public List<Member> membersFindList();

}